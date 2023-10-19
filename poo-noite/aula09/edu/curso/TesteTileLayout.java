package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TesteTileLayout extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       TilePane pane = new TilePane();
       Scene scn = new Scene(pane, 800, 600);
       stage.setScene(scn);

       Label lblTeste = new Label("Ola mundo Layouts");
       TextField txtTeste = new TextField();
       Button btnOk = new Button("Ok");
       Button btnCancela = new Button("Cancela");

       pane.getChildren().addAll(lblTeste, txtTeste, btnOk, btnCancela);
       stage.setTitle("Teste de Layout");
       stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(TesteTileLayout.class, args);
    }
}