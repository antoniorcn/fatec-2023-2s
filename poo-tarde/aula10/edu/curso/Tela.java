package edu.curso;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// class Clique implements EventHandler<MouseEvent> {
//     private Label lblTeste;

//     public Clique( Label lblTeste) { 
//         this.lblTeste = lblTeste;
//     }

//     @Override
//     public void handle(MouseEvent event) {
//         lblTeste.setText("Novo Valor do Label");
//     } 
// }

public class Tela extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox painel = new VBox();
        Scene scn = new Scene(painel, 800, 600);

        Label lblTeste = new Label("Teste de Botão");
        Button btnTeste = new Button("Clique-me");

        // Clique clk = new Clique( lblTeste );
        // btnTeste.addEventFilter(MouseEvent.MOUSE_CLICKED, clk);

        // btnTeste.addEventFilter(MouseEvent.MOUSE_CLICKED, 
        //     new EventHandler<MouseEvent>(){
        //         public void handle(MouseEvent ev) { 
        //             System.out.println("Botão clicado");
        //         }
        //     }
        // );

        // btnTeste.addEventFilter(MouseEvent.MOUSE_CLICKED,
        // (MouseEvent ev) -> {
        //     System.out.println("Clicado função Lambda");
        // });

        // btnTeste.addEventFilter(MouseEvent.MOUSE_CLICKED, 
        //     e -> System.out.println("Clique função lambda simplificada") 
        // );

        // btnTeste.setOnMouseClicked( 
        //     e -> System.out.println("Mais simplificado ainda")
        // );

        btnTeste.setOnMouseClicked( 
            e -> lblTeste.setText("Novo Valor do Label mudado por Lambda")
        );

        painel.getChildren().addAll(lblTeste, btnTeste);

        stage.setScene(scn);
        stage.setTitle("Teste de botão");
        stage.show();

    } 

    public static void main(String[] args) {
        Application.launch(Tela.class, args);
    }

}