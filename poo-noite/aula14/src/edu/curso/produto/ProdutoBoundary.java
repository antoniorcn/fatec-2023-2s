package edu.curso.produto;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ProdutoBoundary extends Application {

	private TextField txtNome = new TextField();
	private TextField txtCodigo = new TextField();
	private TextField txtPreco = new TextField();
	private ProdutoControl control = new ProdutoControl();
	private TableView<Produto> table = new TableView<>();
	
	@Override
	public void start(Stage stage) { 
		BorderPane panePrincipal = new BorderPane();
		Scene scn = new Scene(panePrincipal, 600, 400);
		
		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction( e -> control.cadastrarProduto() );
		Button btnProcurar = new Button("Procurar");
		btnProcurar.setOnAction( e -> control.procurarProduto() );
		
		Label lblNome = new Label("Nome: ");
		
		GridPane paneForm = new GridPane();
		paneForm.add(lblNome, 0, 0);
		paneForm.add(txtNome, 1, 0);
		paneForm.add(new Label("Codigo: "), 0, 1);
		paneForm.add(txtCodigo, 1, 1);
		paneForm.add(new Label("Preço: "), 0, 2);
		paneForm.add(txtPreco, 1, 2);
		paneForm.add(btnCadastrar, 0, 3);
		paneForm.add(btnProcurar, 1, 3);
		
		panePrincipal.setTop(paneForm);
		panePrincipal.setCenter(table);
		
		binding();
		createColumns();
		
		stage.setScene(scn);
		stage.setTitle("Gestão de Produtos");
		stage.show();
	}
	
	public void binding() { 
		Bindings.bindBidirectional(txtNome.textProperty(),
				control.nomeProperty());
		Bindings.bindBidirectional(txtCodigo.textProperty(), 
				control.codigoProperty());
		Bindings.bindBidirectional(txtPreco.textProperty(), 
				control.precoProperty(),
				new NumberStringConverter());
	}
	
	public void createColumns() { 
		table.setItems(control.getLista());
		TableColumn<Produto, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(
						itemData.getValue().getNome()
					));
		TableColumn<Produto, String> colCodigo = new TableColumn<>("Codigo");
		colCodigo.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(
				itemData.getValue().getCodigo()
			));
		TableColumn<Produto, Double> colPreco = new TableColumn<>("Preço");
		colPreco.setCellValueFactory(
				new PropertyValueFactory<Produto, Double>("preco"));
		table.getColumns().addAll(colNome, colCodigo, colPreco);
	}
	
	public static void main(String args[]) { 
		Application.launch(ProdutoBoundary.class, args);
	}
}
