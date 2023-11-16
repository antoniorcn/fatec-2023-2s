package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Teste {
	private static final String URL = 
			"jdbc:mariadb://localhost:3306/contatos?characterEncoding=utf8";
	private static final String USER = "root";
	private static final String PASS = "alunofatec";
	public static void main(String[] args) { 
		Map<String, Object> telas = new HashMap<>();
		
		Object telaA = new Object();
		Object telaB = new Object();
		Object telaC = new Object();
		
		telas.put("A", telaA);
		telas.put("B", telaB);
		telas.put("C", telaC);
		
		Object tela = telas.get("B");
	
		throws ClassNotFoundException, SQLException {
		System.out.println("Iniciando conexão");
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println("Classe foi carregada");
		// create database contatos;
		Connection con = 
				DriverManager.getConnection( URL, USER, PASS );
		System.out.println("Conexão estabelecida");
		
	}
}
