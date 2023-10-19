package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteFlowLayout extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       FlowPane pane = new FlowPane();
       pane.setHgap(10);
       pane.setVgap(40);
       Scene scn = new Scene(pane, 800, 600);
       stage.setScene(scn);

       Label lblTeste = new Label("Ola mundo Layouts");
       TextField txtTeste = new TextField();
       Button btnOk = new Button("Ok");

       pane.getChildren().addAll(lblTeste, txtTeste, btnOk);

       stage.setTitle("Teste de Layout");
       stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(TesteFlowLayout.class, args);
    }
}