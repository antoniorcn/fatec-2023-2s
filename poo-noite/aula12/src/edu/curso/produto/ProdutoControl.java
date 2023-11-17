package edu.curso.produto;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoControl {
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty codigo = new SimpleStringProperty("");
	private DoubleProperty preco = new SimpleDoubleProperty(0);
	private ObservableList<Produto> lista = 
				FXCollections.observableArrayList();
	
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
		lista.add(p);
	}
	
	public void procurarProduto() { 
	 	for (int i = 0; i < lista.size(); i++) { 
	 		Produto p = lista.get(i);
	 		if (p.getNome().contains( nome.get() )) {
	 			nome.set( p.getNome() );
	 			codigo.set( p.getCodigo() );
	 			preco.set( p.getPreco() );
	 			break;
	 		}
	 	}
		
	}
}
