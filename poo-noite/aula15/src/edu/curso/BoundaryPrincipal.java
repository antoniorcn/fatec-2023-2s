package edu.curso;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BoundaryPrincipal extends Application implements Executador {
	
	private BoundaryRender alunoBoundary = new AlunoBoundary();
	private UsuarioBoundary usuarioBoundary = new UsuarioBoundary(this);
	private BorderPane panPrincipal = new BorderPane();
	
	private void logado() { 
		MenuBar mnuPrincipal = new MenuBar();
		Menu mnuFile = new Menu("Arquivo");
		Menu mnuCadastro = new Menu("Cadastro");
		MenuItem mnuItemSair = new MenuItem("Sair");
		MenuItem mnuItemAlunos = new MenuItem("Alunos");
		mnuPrincipal.getMenus().addAll(mnuFile, mnuCadastro);
		mnuFile.getItems().addAll(mnuItemSair);
		mnuCadastro.getItems().add(mnuItemAlunos);
		
		mnuItemSair.setOnAction(
				e-> {
					Platform.exit();
					System.exit(0);
				}
		);
		
		mnuItemAlunos.setOnAction(
				e-> {
					panPrincipal.setCenter(alunoBoundary.render());
				}
		);
		panPrincipal.setTop(mnuPrincipal);
		panPrincipal.setCenter(null);
	}
	
	public void naoLogado() { 
		panPrincipal.setTop(null);
		panPrincipal.setCenter(usuarioBoundary.render());
	}
	
	public void updateLogin() { 
		if (usuarioBoundary.isLogado()) { 
			logado();
		} else { 
			naoLogado();
		}
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
				
		Scene scn = new Scene(panPrincipal, 800, 600);
		
		updateLogin();
		
		stage.setScene(scn);
		stage.setTitle("Gestão Escolar");
		stage.show();
	}
	
	public static void main(String[] args) { 
		Application.launch(BoundaryPrincipal.class, args);
	}

	@Override
	public void executar() {
		updateLogin();	
		System.out.println("Logado " + usuarioBoundary.isLogado());
	}

}
