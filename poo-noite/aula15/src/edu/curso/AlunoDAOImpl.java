package edu.curso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {
	
	private static final String JDBC_URL =
			"jdbc:mariadb://localhost:3306/escola?characterEncoding=latin1";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "alunofatec";
	private Connection con;
	public AlunoDAOImpl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void salvar(Aluno a) {
		String sql = "INSERT INTO alunos "
			+ "(id, ra, nome, nascimento) VALUES "
			+ "(?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, a.getId());
			stmt.setString(2, a.getRa());
			stmt.setString(3, a.getNome());
			stmt.setDate(4, Date.valueOf(a.getNascimento()));
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Aluno> lerTodos() {
		return pesquisarNome("");
	}

	@Override
	public List<Aluno> pesquisarNome(String nome) {
		// TODO Auto-generated method stub
		List<Aluno> lista = new ArrayList<>();
		String sql = "SELECT * FROM alunos WHERE nome LIKE ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Aluno a = new Aluno();
				a.setId( rs.getLong("id") );
				a.setRa( rs.getString("ra") );
				a.setNome( rs.getString("nome") );
				a.setNascimento( rs.getDate("nascimento").toLocalDate() );
				lista.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
