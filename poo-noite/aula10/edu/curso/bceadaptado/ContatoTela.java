package edu.curso.bceadaptado;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContatoTela extends Application {

    private TextField txtNome = new TextField();
    private TextField txtEmail = new TextField();

    private ContatoControl control = new ContatoControl();

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
        Contato c = gerarEntitidade(); 
        control.salvar( c );
    }

    public void pesquisar() { 
        Contato c = control.pesquisar( txtNome.getText() );
        if (c != null) {
            entidadeParaTela( c ); 
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
