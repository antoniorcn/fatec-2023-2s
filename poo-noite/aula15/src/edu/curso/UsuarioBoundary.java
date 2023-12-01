package edu.curso;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class UsuarioBoundary implements BoundaryRender {
	private TextField txtUsuairo = new TextField();
	private TextField txtSenha = new TextField();
	private Button btnLogin = new Button("Login");
	
	private UsuarioControl control = new UsuarioControl();
	private Executador boundaryPrincipal;
	
	
	public UsuarioBoundary(Executador boundaryPrincipal) {
		this.boundaryPrincipal = boundaryPrincipal;
		
	}


	public void generateBindings() { 
		Bindings.bindBidirectional(txtUsuairo.textProperty(), control.usuarioProperty());
		Bindings.bindBidirectional(txtSenha.textProperty(), control.senhaProperty());
	}

	
	@Override
	public Pane render() {
		BorderPane panPrincipal = new BorderPane();
			
		GridPane panFormulario = new GridPane();
		panFormulario.add(new Label("Usuario: "), 0, 0);
		panFormulario.add(txtUsuairo, 1, 0);
		panFormulario.add(new Label("Senha: "), 0, 1);
		panFormulario.add(txtSenha, 1, 1);
		panFormulario.add(btnLogin, 0, 2);
		
		btnLogin.setOnAction( e -> {
			control.login();
			boundaryPrincipal.executar();
		});
		
		panPrincipal.setCenter(panFormulario);
		
		generateBindings();
		return panPrincipal;
	}
	
	public boolean isLogado() { 
		return control.isLogado();
	}
	
	

}
