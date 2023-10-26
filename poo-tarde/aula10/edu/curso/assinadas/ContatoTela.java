package edu.curso.assinadas;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContatoTela extends Application {
    private TextField txtNome;
    private TextField txtEmail;
    private ContatoControl control = new ContatoControl();

    @Override
    public void start(Stage stage) throws Exception {
        VBox painel = new VBox();
        Scene scn = new Scene(painel, 800, 600);

        Label lblNome = new Label("Nome Completo: ");
        txtNome = new TextField();
        Label lblEmail = new Label("eMail: ");
        txtEmail = new TextField();
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        Bindings.bindBidirectional(control.nomeProperty(), txtNome.textProperty());
        Bindings.bindBidirectional(control.emailProperty(), txtEmail.textProperty());

        btnSalvar.setOnMouseClicked( 
            e-> { 
                control.salvarContato();
            }
        );

        btnPesquisar.setOnMousePressed(
            e -> { 
                control.procurar();
            }
        );

        painel.getChildren().addAll(lblNome, txtNome, lblEmail, 
                                    txtEmail, btnSalvar, btnPesquisar);

        stage.setScene(scn);
        stage.setTitle("BCE Real");
        stage.show();

    } 

    public static void main(String[] args) {
        Application.launch(ContatoTela.class, args);
    }

}