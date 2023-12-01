package edu.curso;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoControl {
	
	private LongProperty id = new SimpleLongProperty(0);
	private StringProperty ra = new SimpleStringProperty("");
	private StringProperty nome  = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>(
			LocalDate.now());
	
	private ObservableList<Aluno> lista = FXCollections.observableArrayList();
	
	private AlunoDAO alunoDAO = new AlunoDAOImpl();
	
	public LongProperty idProperty() { 
		return this.id;
	}
	public StringProperty raProperty() { 
		return this.ra;
	}
	public StringProperty nomeProperty() { 
		return this.nome;
	}
	public ObjectProperty<LocalDate> nascimentoProperty() { 
		return this.nascimento;
	}
	
	public ObservableList<Aluno> getLista() { 
		return this.lista;
	}
	
	public void salvar() { 
		Aluno a = new Aluno();
		a.setId(id.get());
		a.setRa(ra.get());
		a.setNome(nome.get());
		a.setNascimento(nascimento.get());
		
		alunoDAO.salvar(a);
		lerTodos();
	}
	
	public void lerTodos() { 
		List<Aluno> alunos = alunoDAO.lerTodos();
		lista.clear();
		lista.addAll( alunos );
	}
	
	public void ler() { 
		List<Aluno> alunos = alunoDAO.pesquisarNome(nome.get());
		lista.clear();
		lista.addAll( alunos );
	}
}
