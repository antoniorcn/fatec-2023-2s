package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TesteBorderLayout extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       BorderPane pane = new BorderPane();
       Scene scn = new Scene(pane, 800, 600);
       stage.setScene(scn);

       Label lblTeste = new Label("Ola mundo Layouts");
       TextField txtTeste = new TextField();

       FlowPane painelBotoes = new FlowPane();
       Button btnOk = new Button("Ok");
       Button btnCancela = new Button("Cancela");

       painelBotoes.getChildren().addAll(btnOk, btnCancela);

       pane.setTop(lblTeste);
       pane.setCenter(txtTeste);
       pane.setBottom(painelBotoes);

       stage.setTitle("Teste de Layout");
       stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(TesteBorderLayout.class, args);
    }
}