package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsuarioControl {
	
	private StringProperty usuario = new SimpleStringProperty("");
	private StringProperty senha  = new SimpleStringProperty("");
	boolean logado = false; 
	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	

	public StringProperty usuarioProperty() { 
		return this.usuario;
	}
	public StringProperty senhaProperty() { 
		return this.senha;
	}
	
	public void login() { 
		logado = usuarioDAO.logar(usuario.get(), senha.get());
	}
	
	public boolean isLogado() { 
		return logado;
	}
}
