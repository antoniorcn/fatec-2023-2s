package edu.curso.produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoControl {
	public static final String JDBC_URL=
			"jdbc:mariadb://localhost:3307/teste";
	public static final String JDBC_USER="root";
	public static final String JDBC_PASS="alunofatec";
	
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty codigo = new SimpleStringProperty("");
	private DoubleProperty preco = new SimpleDoubleProperty(0);
	private ObservableList<Produto> lista = 
				FXCollections.observableArrayList();
	
	private Connection con;
	
	public ProdutoControl() {
		try { 
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			procurarProduto();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	public StringProperty nomeProperty() { 
		return this.nome;
	}
	public StringProperty codigoProperty() {
		return this.codigo;
	}
	public DoubleProperty precoProperty() { 
		return this.preco;
	}
	
	public ObservableList<Produto> getLista() { 
		return this.lista;
	}
	
	public void cadastrarProduto() {
		Produto p = new Produto();
		p.setNome(nome.get());
		p.setCodigo(codigo.get());
		p.setPreco(preco.get());
		
		try { 
			String sql = "INSERT INTO produtos (codigo, nome, preco) "
					+ "VALUES (?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, codigo.get());
			stmt.setString(2, nome.get());
			stmt.setDouble(3, preco.get());
			stmt.executeUpdate();
		} catch(Exception e) { 
			e.printStackTrace();
		}
		
		nome.set("");
		codigo.set("");
		preco.set(0);
		procurarProduto();
	}
	
	public void procurarProduto() {
		try { 
			String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome.get() + "%");
			ResultSet rs = stmt.executeQuery();
			lista.clear();
			while(rs.next()) { 
				Produto p = new Produto();
				p.setCodigo( rs.getString("codigo")  );
				p.setNome( rs.getString("nome")  );
				p.setPreco( rs.getDouble("preco")  );
				lista.add(p);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}
}
