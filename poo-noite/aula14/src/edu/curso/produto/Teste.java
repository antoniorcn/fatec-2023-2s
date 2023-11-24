package edu.curso.produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {
	public static final String JDBC_URL=
			"jdbc:mariadb://localhost:3307/teste";
	public static final String JDBC_USER="root";
	public static final String JDBC_PASS="alunofatec";
	public static void main(String[] args) {
		try {
			System.out.println("Programa iniciado");
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe carregada");

			Connection con = 
				DriverManager.getConnection(
						JDBC_URL, JDBC_USER, JDBC_PASS);
			System.out.println("Conexão feita");
//			String sql = """
//					INSERT INTO produtos 
//						(codigo, nome, preco) 
//					VALUES 
//						('002', 'Cadeira', 9.99);
//					""";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.executeUpdate();
//			System.out.println("Produto inserido");
			
			String sql = "SELECT * FROM produtos";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				String codigo = rs.getString("codigo");
				String nome = rs.getString("nome");
				double preco = rs.getDouble("preco");
				System.out.println(
						"Registro: %s\t%s\t%5.2f"
						.formatted(codigo, nome, preco));
			}
			con.close();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
}
