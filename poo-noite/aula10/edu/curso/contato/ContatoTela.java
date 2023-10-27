package edu.curso.contato;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContatoTela extends Application {

    private List<Contato> lista = new ArrayList<>();
    private TextField txtNome = new TextField();
    private TextField txtEmail = new TextField();

    public Contato gerarEntitidade() { 
        Contato c = new Contato();
        c.setNome( txtNome.getText() );
        c.setEmail( txtEmail.getText() );
        return c;
    }

    public void entidadeParaTela( Contato c ) { 
        txtNome.setText( c.getNome() );
        txtEmail.setText( c.getEmail() );
    }

    public void salvar() { 
        lista.add( gerarEntitidade() );
        System.out.println("Contatos: " + lista.size());
    }

    public void pesquisar() { 
        for (Contato c : lista) { 
            if (c.getNome().contains(txtNome.getText())) { 
                entidadeParaTela(c);
                break;
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scn = new Scene(pane, 640, 480);

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        btnSalvar.setOnAction( e -> salvar() );

        btnPesquisar.setOnAction( e -> pesquisar() );

        pane.add(new Label("Nome: "), 0, 0);
        pane.add(txtNome, 1, 0);
        pane.add(new Label("Email: "), 0, 1);
        pane.add(txtEmail, 1, 1);
        pane.add(btnSalvar, 0, 2);
        pane.add(btnPesquisar, 1, 2);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContatoTela.class, args);
    }
}
