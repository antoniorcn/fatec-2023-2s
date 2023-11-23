package edu.curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO {

	@Override
	public void salvar(Curso c) {
		try { 
			Connection con = Conexao.getInstance().getConnection();
			String sql = "INSERT INTO cursos (nome, codigo, qtd_alunos, data_enade) " + 
						"VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNomeCurso());
			stmt.setString(2, c.getCodCurso());
			stmt.setInt(3, c.getQtdAlunos());
			stmt.setDate(4, java.sql.Date.valueOf(c.getProximoEnade()));
			stmt.executeUpdate();
			stmt.close();
			Conexao.getInstance().close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}		
	}

	@Override
	public List<Curso> carregarTodos() {
		List<Curso> lista = new ArrayList<>();
		try {
			Connection con = Conexao.getInstance().getConnection();
			String sql = "SELECT id, nome, codigo, qtd_alunos, data_enade FROM cursos";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) { 
				Curso c = new Curso();
				c.setId(rs.getLong("id"));
				c.setNomeCurso(rs.getString("nome"));
				c.setCodCurso(rs.getString("codigo"));
				c.setQtdAlunos(rs.getInt("qtd_alunos"));
				c.setProximoEnade(rs.getDate("data_enade").toLocalDate());
				lista.add(c);
			}
			Conexao.getInstance().close();
		} catch(SQLException e) { 
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void apagar(long id) {
		try {
			Connection con = Conexao.getInstance().getConnection();
			String sql = "DELETE FROM cursos WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			Conexao.getInstance().close();
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}

}
