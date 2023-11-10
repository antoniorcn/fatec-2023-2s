package edu.curso;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaTeste extends Application {

	private TextField txtNome = new TextField();
	private StringProperty nome = new SimpleStringProperty("");
	
	@Override
	public void start(Stage stage) throws Exception {
		FlowPane pane = new FlowPane();
		Scene scn = new Scene(pane, 600, 400);
		
		Bindings.bindBidirectional(txtNome.textProperty(), nome);
		
		
		nome.set("Joao");
		
		
//		txtNome.textProperty().addListener(
//				(obs, antigo, novo) -> {
//					System.out.println(antigo + " -> " + novo);
//				}
//		);
		
		pane.getChildren().add(txtNome);
		
		stage.setScene(scn);
		stage.setTitle("Gestão e Clientes");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaTeste.class, args);
	}

}
