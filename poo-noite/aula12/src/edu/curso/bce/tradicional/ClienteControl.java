package edu.curso.bce.tradicional;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClienteControl {
	
	private ObservableList<Cliente> lista = 
				FXCollections.observableArrayList();
	
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty cpf = new SimpleStringProperty("");
	
	public void gerarCliente() { 
		Cliente c = new Cliente();
		c.setNome( nome.get() );
		c.setCpf( cpf.get() );
		lista.add( c );
	}
	
	public void procurarCliente() { 
		for (Cliente c : lista) { 
			if (c.getNome().contains(nome.get())) { 
				nome.set( c.getNome() );
				cpf.set( c.getCpf() );
			}
		}
	}

	public StringProperty nomeProperty() { 
		return nome;
	}
	public StringProperty cpfProperty() { 
		return cpf;
	}
	
	public ObservableList<Cliente> getLista() { 
		return lista;
	}

}
