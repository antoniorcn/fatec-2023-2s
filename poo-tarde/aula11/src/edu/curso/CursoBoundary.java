package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

public class CursoBoundary extends Application {
	
	private TextField txtNomeCurso = new TextField();
	private TextField txtCodCurso = new TextField();
	private TextField txtNomeCoord = new TextField();
	private TextField txtQtdAlunos = new TextField();
	private DatePicker dtDataEnade = new DatePicker();
	private Button btnSalvar = new Button("Salvar");
	private Button btnPesquisar = new Button("Pesquisar");
	private TableView<Curso> table = new TableView<>();
	
	private CursoControl control = new CursoControl(); 
	
	public void bindings() { 
		Bindings.bindBidirectional(txtNomeCurso.textProperty(), control.nomeCursoProperty());
		Bindings.bindBidirectional(txtCodCurso.textProperty(), control.codigoCursoProperty());
		Bindings.bindBidirectional(txtNomeCoord.textProperty(), control.nomeCoordProperty());
		Bindings.bindBidirectional(txtQtdAlunos.textProperty(), control.qtdAlunosProperty(), 
				(StringConverter<Number>) new NumberStringConverter());		
		Bindings.bindBidirectional(dtDataEnade.valueProperty(), control.dataEnadeProperty());
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		Bindings.bindBidirectional(txtDataEnade.textProperty(), control.dataEnadeProperty(),
//				new LocalDateStringConverter(dtf, dtf));
	}
	
	@SuppressWarnings("unchecked")
	public void populateTable() { 
		TableColumn<Curso, String> col1 = new TableColumn<>("Nome do Curso");
		col1.setCellValueFactory( new PropertyValueFactory<Curso, String>("nomeCurso"));
		
		TableColumn<Curso, String> col2 = new TableColumn<>("Codigo do Curso");
		col2.setCellValueFactory( 
				itemData -> new ReadOnlyStringWrapper( itemData.getValue().getCodCurso() )
		);
		
		TableColumn<Curso, String> col3 = new TableColumn<>("Qtd. Alunos");
		col3.setCellValueFactory( 
				itemData -> new ReadOnlyStringWrapper(
						String.valueOf( itemData.getValue().getQtdAlunos() ) )
		);
		
		TableColumn<Curso, String> col4 = new TableColumn<>("Data do Enade");
		col4.setCellValueFactory(
				itemData -> { 
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dt = itemData.getValue().getProximoEnade();
					String dataStr = dtf.format(dt); 
					return new ReadOnlyStringWrapper(dataStr); 
				}
		);
		
		table.getColumns().addAll(col1, col2, col3, col4);
		table.getSelectionModel().selectedItemProperty().addListener(
				(obs, antigo, novo) -> { 
					control.popularTela( novo );
				}
		);
	}
	
	@Override
	public void start(Stage stage) { 
		BorderPane pane = new BorderPane();
		GridPane grid = new GridPane();
		grid.setOnMouseClicked(
				e -> table.getSelectionModel().clearSelection()
		);
		pane.setTop(grid);
		pane.setCenter(table);
		Scene scn = new Scene(pane, 600, 400);
				
		grid.add( new Label("Nome Curso"), 0, 0 );
		grid.add( txtNomeCurso, 1, 0);
		grid.add( new Label("Codigo Curso"), 0, 1 );
		grid.add( txtCodCurso, 1, 1);
		grid.add( new Label("Nome Coordenador"), 0, 2 );
		grid.add( txtNomeCoord, 1, 2);
		grid.add( new Label("Quantidade de Alunos"), 0, 3 );
		grid.add( txtQtdAlunos, 1, 3);
		grid.add( new Label("Proximo Enade"), 0, 4 );
		grid.add( dtDataEnade, 1, 4);
		grid.add(btnSalvar, 0, 5);
		grid.add(btnPesquisar, 1, 5);
		
		btnSalvar.setOnAction( e -> control.salvar() );
		
		btnPesquisar.setOnAction( e -> control.pesquisar() );
		
		table.setItems( control.getLista() );
		bindings();
		populateTable();
		
		stage.setScene(scn);
		stage.setTitle("Gestão de Cursos");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(CursoBoundary.class, args);
	}

}
