package edu.curso;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CursoControl {
	private CursoDAO cursoDAO = new CursoDAOImpl();
	private ObservableList<Curso> lista = FXCollections.observableArrayList();
	
	private StringProperty nomeCurso = new SimpleStringProperty("");
	private StringProperty codigoCurso = new SimpleStringProperty("");
	private StringProperty nomeCoord = new SimpleStringProperty("");
	private IntegerProperty qtdAlunos = new SimpleIntegerProperty(0);
	private ObjectProperty<LocalDate> dataEnade 
			= new SimpleObjectProperty<>( LocalDate.now() );
	

	public CursoControl () {
		lerDados();
	}
	
	
	public void salvar() { 
		System.out.println("Nome curso: " + nomeCurso.get());
		System.out.println("Codigo curso: " + codigoCurso.get());
		System.out.println("Nome coordenador: " + nomeCoord.get());
		System.out.println("Qtd Alunos: " + qtdAlunos.get());
		System.out.println("Data Enade: " + dataEnade.get());
		Curso c = new Curso()
				.setId(0)
				.setNomeCurso(nomeCurso.get())
				.setCodCurso(codigoCurso.get())
				.setNomeCoordenador(nomeCoord.get())
				.setQtdAlunos(qtdAlunos.get())
				.setProximoEnade(dataEnade.get());
		cursoDAO.salvar(c);
		
		HttpClient httpClient = HttpClient.newBuilder()
	            .version(HttpClient.Version.HTTP_2)
	            .connectTimeout(Duration.ofSeconds(10))
	            .build();
		String json = """
				{
				    "id": 1,
				    "nomeCurso": "%s",
				    "codigoCurso": "%s",
				    "coordenador": "%s",
				    "dataEnade": "2024-11-23",
				    "qtdAlunos": %d
				}
				""".formatted(nomeCurso.get(), 
						codigoCurso.get(),
						nomeCoord.get(),
						qtdAlunos.get());
		BodyPublisher body = BodyPublishers.ofString(json);
		HttpRequest request = HttpRequest.newBuilder()
				.POST(body)
                .uri(URI.create("https://teste-c3018-default-rtdb.asia-southeast1.firebasedatabase.app/cursos.json"))
                .header("Content-Type", "application/json")
                .build();

		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Resposta: " + response.body());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		lerDados();
	}
	
	public void pesquisar() { 
		String nome = nomeCurso.get();
		for (Curso c : lista) { 
			if (c.getNomeCurso().contains(nome)) { 
				popularTela( c );
			}
		}
	}
	
	public void apagar(Curso c) { 
		cursoDAO.apagar(c.getId());
		lerDados();
	}
	
	public void lerDados() { 
		lista.clear();
		List<Curso> novaLista = cursoDAO.carregarTodos();
		lista.addAll(novaLista);
	}
	
	public void popularTela( Curso c ) { 
		if (c != null) {
			nomeCurso.set( c.getNomeCurso() );
			codigoCurso.set( c.getCodCurso() );
			nomeCoord.set( c.getNomeCoordenador() );
			qtdAlunos.set( c.getQtdAlunos() );
			dataEnade.set( c.getProximoEnade() );
		}
	}
	
	
	public StringProperty nomeCursoProperty() { 
		return nomeCurso;
	}
	
	public StringProperty codigoCursoProperty() { 
		return codigoCurso;
	}
	
	public StringProperty nomeCoordProperty() { 
		return nomeCoord;
	}
	
	public IntegerProperty qtdAlunosProperty() { 
		return qtdAlunos;
	}
	
	public ObjectProperty<LocalDate> dataEnadeProperty() { 
		return dataEnade;
	}	
	
	public ObservableList<Curso> getLista() { 
		return lista;
	}
	

}
