package edu.curso.bce.tradicional;

import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClienteBoundary extends Application {

	private TextField txtNome = new TextField();
	private TextField txtCpf = new TextField();
	private TextField txtMilhas = new TextField();
	private TextField txtNascimento = new TextField();
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");
	private DateTimeFormatter dtf =
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private ClienteControl control = new ClienteControl();
	
	private TableView<Cliente> table = new TableView<>();
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane panePrincipal = new BorderPane();
		GridPane grid = new GridPane();
		Scene scn = new Scene(panePrincipal, 600, 400);
		panePrincipal.setTop(grid);
		panePrincipal.setCenter(table);
		
		Bindings.bindBidirectional(
				txtNome.textProperty(), control.nomeProperty() );
		Bindings.bindBidirectional(
				txtCpf.textProperty(), control.cpfProperty() );
		
		TableColumn<Cliente, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(
				itemData -> new ReadOnlyStringWrapper(
								itemData.getValue().getNome()
								));
		TableColumn<Cliente, String> colCpf = new TableColumn<>("C.P.F.");
		colCpf.setCellValueFactory(
				itemData -> new ReadOnlyStringWrapper(
						itemData.getValue().getCpf()
						));
		table.getColumns().addAll(colNome, colCpf);
		
		table.setItems( control.getLista() );
		
		
		grid.add(new Label("Nome do Cliente: "), 0, 0);
		grid.add(txtNome, 1, 0);
		grid.add(new Label("CPF: "), 0, 1);
		grid.add(txtCpf, 1, 1);
		grid.add(new Label("Milhas: "), 0, 2);
		grid.add(txtMilhas, 1, 2);
		grid.add(new Label("Data Nascimento: "), 0, 3);
		grid.add(txtNascimento, 1, 3);
		grid.add(btnSalvar, 0, 4);
		grid.add(btnPesquisar, 1, 4);
		
		btnSalvar.setOnAction( 
				e -> {
					control.gerarCliente();
				});
		
		btnPesquisar.setOnAction(
				e -> {
					control.procurarCliente();
				});
		
		stage.setScene(scn);
		stage.setTitle("Gestão e Clientes");
		stage.show();
	}
	
	
	public static void main(String[] args) {
		Application.launch(ClienteBoundary.class, args);
	}

}
