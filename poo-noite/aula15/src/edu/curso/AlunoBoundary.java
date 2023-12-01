package edu.curso;

import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;
import javafx.util.converter.NumberStringConverter;

public class AlunoBoundary implements BoundaryRender {
	private TableView<Aluno> table = new TableView<>();
	private TextField txtId = new TextField();
	private TextField txtRa = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtNascimento = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private AlunoControl control = new AlunoControl();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void generateBindings() { 
		Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(),
				new NumberStringConverter());
		Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
		StringConverter localDtf = new LocalDateStringConverter(dtf, dtf);
		Bindings.bindBidirectional(txtNascimento.textProperty(), control.nascimentoProperty(),
						localDtf);
	}
	
	public void generateTable() { 
		
		table.setItems( control.getLista() );
		
		TableColumn<Aluno, Long> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(
				new PropertyValueFactory<Aluno, Long>("id") );
		
		TableColumn<Aluno, String> colRa = new TableColumn<>("RA");
		colRa.setCellValueFactory(
			itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getRa()));
		
		TableColumn<Aluno, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(
			itemData ->	new ReadOnlyStringWrapper(itemData.getValue().getNome()));
		
		TableColumn<Aluno, String> colNasc = new TableColumn<>("Nascimento");
		colNasc.setCellValueFactory(
			itemData ->	new ReadOnlyStringWrapper(
					dtf.format(itemData.getValue().getNascimento())
			));		
	
		table.getColumns().addAll(colId, colRa, colNome, colNasc);
	}
	
	public Pane render() { 
		BorderPane panPrincipal = new BorderPane();
		
		txtId.setEditable(false);
		
		GridPane panFormulario = new GridPane();
		panFormulario.add(new Label("Id: "), 0, 0);
		panFormulario.add(txtId, 1, 0);
		panFormulario.add(new Label("Ra: "), 0, 1);
		panFormulario.add(txtRa, 1, 1);
		panFormulario.add(new Label("Nome: "), 0, 2);
		panFormulario.add(txtNome, 1, 2);
		panFormulario.add(new Label("Nascimento: "), 0, 3);
		panFormulario.add(txtNascimento, 1, 3);
		panFormulario.add(btnAdicionar, 0, 4);
		panFormulario.add(btnPesquisar, 1, 4);
		
		btnAdicionar.setOnAction( e-> control.salvar() );
		btnPesquisar.setOnAction( e -> control.ler() );
		
		panPrincipal.setCenter(table);
		panPrincipal.setTop(panFormulario);

		generateBindings();
		generateTable();
		return panPrincipal;
	}
}
