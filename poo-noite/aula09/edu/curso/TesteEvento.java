package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class Interceptador implements EventHandler<MouseEvent> { 
    public void handle(MouseEvent e) {
        System.out.printf("Source(%s)\tTarget(%s)\t" + 
        "Tipo(%s)\tX(%5.1f)\tY(%5.1f)\tBotao1(%b)\n",
            e.getSource().getClass().getName(), //Source
            e.getTarget().getClass().getName(), //Target
            e.getEventType(),
            e.getX(),
            e.getY(),
            e.isPrimaryButtonDown());
        e.consume();
    }
}

public class TesteEvento extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);

        Interceptador intercept = new Interceptador();

        Label lblTeste = new Label("Ola mundo Layouts");
        TextField txtTeste = new TextField();
        Button btnOk = new Button("Ok");
        Button btnCancela = new Button("Cancela");

        stage.addEventFilter(
            MouseEvent.ANY, intercept);
        pane.add(lblTeste, 0, 0);

        pane.add(txtTeste, 1, 0);
        pane.add(btnOk, 0, 1);
        pane.add(btnCancela, 1, 1);

        stage.setTitle("Teste de Layout");
        stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(TesteEvento.class, args);
    }
}