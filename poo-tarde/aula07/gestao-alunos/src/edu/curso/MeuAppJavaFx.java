package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MeuAppJavaFx extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane painel = new BorderPane();
        Scene scn = new Scene(painel, 640, 480);
        stage.setScene( scn );

        Label lblNome = new Label("Nome:");
        lblNome.setStyle(
           "-fx-background-color: rgba( 255 , 0 , 0 , 0.5 ); " +
                   "-fx-background-radius: 20px; " +
                   "-fx-min-width: 100%; -fx-min-height: 20%"
        );
        TextField txtNome = new TextField();
        Button btn = new Button("Salvar");


        painel.setTop(lblNome);
        painel.setCenter(txtNome);
        painel.setBottom(btn);

        stage.setTitle("Minha primeira Aplicação");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(MeuAppJavaFx.class, args);
    }
}
