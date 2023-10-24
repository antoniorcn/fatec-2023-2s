package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TesteGridLayout extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       GridPane pane = new GridPane();
       Scene scn = new Scene(pane, 800, 600);
       stage.setScene(scn);

       Label lblTeste = new Label("Ola mundo Layouts");
       TextField txtTeste = new TextField();
       Button btnOk = new Button("Ok");
       Button btnCancela = new Button("Cancela");

       pane.add(lblTeste, 0, 0);

        pane.add(txtTeste, 1, 0);
        pane.add(btnOk, 0, 1);
        pane.add(btnCancela, 1, 1);

       stage.setTitle("Teste de Layout");
       stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(TesteGridLayout.class, args);
    }
}