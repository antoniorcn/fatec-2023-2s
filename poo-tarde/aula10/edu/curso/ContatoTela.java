package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
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

        btnSalvar.setOnMouseClicked( 
            e-> { 
                control.salvar( toEntity() );
                clearBoundary();
            }
        );

        btnPesquisar.setOnMousePressed(
            e -> { 
                Contato c = control.pesquisar( txtNome.getText() );
                fromEntity(c);
            }
        );

        painel.getChildren().addAll(lblNome, txtNome, lblEmail, 
                                    txtEmail, btnSalvar, btnPesquisar);

        stage.setScene(scn);
        stage.setTitle("Teste de botão");
        stage.show();

    } 

    public void clearBoundary() { 
        txtNome.setText("");
        txtEmail.setText("");
    }

    public Contato toEntity() { 
        Contato c = new Contato();
        c.setNome(txtNome.getText());
        c.setEmail(txtEmail.getText());
        return c;
    }

    public void fromEntity(Contato c) { 
        if (c != null) { 
            txtNome.setText(c.getNome());
            txtEmail.setText(c.getEmail());
        } else { 
            Alert a = new Alert(
                AlertType.INFORMATION, 
                    "Contato não encontrado", 
                    new ButtonType("Ok")
            );
            a.show();
        }
    }

    public static void main(String[] args) {
        Application.launch(ContatoTela.class, args);
    }

}