package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mariadb://localhost:3307/escola";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "alunofatec";

	private static Conexao instancia = new Conexao();
	private Connection con;
	
	private Conexao() { 
		criarConexao();
	}
	
	private void criarConexao() { 
		try { 
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch(ClassNotFoundException e) { 
			e.printStackTrace();
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			if (con == null || con.isClosed()) { 
				criarConexao();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void close() { 
		try { 
			if (con != null) { 
				con.close();
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public static Conexao getInstance() { 
		return instancia;
	}
}
