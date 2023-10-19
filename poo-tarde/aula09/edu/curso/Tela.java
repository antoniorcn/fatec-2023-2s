package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class CapturaEvento implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        System.out.print("Evento " + event.getEventType());
        System.out.print("\tSource " + event
            .getSource().getClass().getName());
        System.out.print("\tTarget " + event
            .getTarget().getClass().getName());            
        System.out.println(
            "\tX: " + event.getX() + 
            "\tY: " + event.getY() + 
            "\tBotoes: primario: " + 
                event.isPrimaryButtonDown());
        event.consume();
    } 
}

public class Tela extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        CapturaEvento cap = new CapturaEvento();
        VBox panel = new VBox();
        Scene scn = new Scene(panel, 640, 400);
        stage.addEventFilter(MouseEvent.ANY, cap);
        Label lblTeste = new Label("Bem Vindo - Teste");
        Button btnClick = new Button("Clique - me");

        panel.getChildren().addAll(lblTeste, btnClick);

        stage.setScene( scn );
        stage.setTitle("Teste de Eventos");
        stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(Tela.class, args);
    }
}