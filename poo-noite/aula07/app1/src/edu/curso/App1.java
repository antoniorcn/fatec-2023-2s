package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App1 extends Application {
	public void start(Stage stage) {
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 640, 480);
		
		Label lblNome = new Label("Nome");
		lblNome.setStyle("-fx-font: normal 32 serif; "
				+ "-fx-background-color: darkcyan; "
				+ "-fx-padding: 30;"
				+ "-fx-background-radius: 20px");
		lblNome.relocate(50, 50);
		TextField txtNome = new TextField();
		txtNome.relocate(200, 50);
		Button btnSalvar = new Button("Salvar");
		btnSalvar.relocate(320, 400);
		
		painel.getChildren().add(lblNome);
		painel.getChildren().add(txtNome);
		painel.getChildren().add(btnSalvar);
		
		stage.setScene(scn);
		stage.setTitle("Meu primeiro App JavaFX");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(App1.class, args);
	}
}
