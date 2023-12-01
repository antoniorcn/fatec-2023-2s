package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAOImpl implements UsuarioDAO {
	private static final String JDBC_URL =
			"jdbc:mariadb://localhost:3306/escola?characterEncoding=latin1";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "alunofatec";
	private Connection con;
	public UsuarioDAOImpl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public boolean logar(String usuario, String senha) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM usuarios WHERE nome = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { 
				return senha.equals(rs.getString("senha"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
