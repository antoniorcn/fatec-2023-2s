package edu.curso.pressionamento;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


class Interceptador implements EventHandler<MouseEvent> { 
    private Label lblTeste;

    public Interceptador( Label valor ) { 
        this.lblTeste = valor;
    }

    public void handle(MouseEvent ev) { 
        System.out.println("Botão foi clicado");
        lblTeste.setText("Novo Texto do Label");
    }
}


public class TestePressionamento1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox();
        Scene scn = new Scene(pane, 600, 400);

        

        Label lblTeste = new Label("Pressionamento do Botão");

        Interceptador intr = new Interceptador( lblTeste );

        Button btnTeste = new Button("Aperte-me");

        btnTeste.addEventFilter(MouseEvent.MOUSE_CLICKED, intr);

        pane.getChildren().addAll(lblTeste, btnTeste);

        stage.setScene(scn);
        stage.setTitle("Teste de Pressionamento do Botão 1");
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(TestePressionamento1.class, args);
    }
   
}
