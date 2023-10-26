package edu.curso.pressionamento;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TestePressionamento3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox();
        Scene scn = new Scene(pane, 600, 400);      

        Label lblTeste = new Label("Pressionamento do Botão");

        Button btnTeste = new Button("Aperte-me");

        btnTeste.addEventFilter(MouseEvent.MOUSE_CLICKED, 
            (MouseEvent ev) -> { 
                lblTeste.setText("Mudando o Texto usando função Lambda");
            }
        );

        pane.getChildren().addAll(lblTeste, btnTeste);

        stage.setScene(scn);
        stage.setTitle("Teste de Pressionamento do Botão 1");
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(TestePressionamento3.class, args);
    }
   
}
