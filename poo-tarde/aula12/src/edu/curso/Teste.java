package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Teste {
	private static final String URL = 
			"jdbc:mariadb://localhost:3307/contatos?"
			+ "characterEncoding=utf8&allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "alunofatec";
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("Iniciando conexão");
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println("Classe foi carregada");
		System.out.println("Por favor digite um nome: ");
		String nome = input.nextLine();
		System.out.println("Agora digite o telefone: ");
		String telefone = input.nextLine();
		System.out.println("Agora digite o email: ");
		String email = input.nextLine();
		// create database contatos;
		Connection con = 
				DriverManager.getConnection( URL, USER, PASS );
		System.out.println("Conexão estabelecida");
		
		String sql = """
				INSERT INTO contatos (nome, telefone, email) VALUES (
					?, ?, ?);
				""";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, telefone);
		stmt.setString(3, email);
		stmt.executeUpdate();
		System.out.println("Comando SQL Executado");
		con.close();		
	}
}
