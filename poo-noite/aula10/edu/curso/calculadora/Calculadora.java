package edu.curso.calculadora;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Calculadora extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String[] nomes = {"1", "2", "3", "+", 
                          "4", "5", "6", "-",
                          "7", "8", "9", "*",
                          ".", "0", "=", "/"};
        GridPane pane = new GridPane();
        Scene scn = new Scene(pane, 300, 400);

        TextField txtDisplay = new TextField();
        txtDisplay.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Button btnCE = new Button("CE");
        btnCE.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        pane.add(txtDisplay, 0, 0, 3, 1);
        pane.add(btnCE, 3, 0);
        for (int i = 0; i < 16; i++) { 
            String titulo = nomes[i];
            Button btnTemp = new Button(titulo);
            btnTemp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            int linha = (int)((i / 4) + 1);
            int coluna = i % 4;
            pane.add(btnTemp, coluna, linha);
        }

        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(25);
        pane.getColumnConstraints().addAll(col, col, col, col);  
        
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(20);
        pane.getRowConstraints().addAll(row, row, row, row, row);
        

        stage.setScene(scn);
        stage.setTitle("Calculadora");
        stage.show();
    } 
 
    public static void main(String[] args) {
        Application.launch(Calculadora.class, args);
    }
}