package edu.curso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CursoControl {
	
	private List<Curso> lista = new ArrayList<>();
	
	private StringProperty nomeCurso = new SimpleStringProperty("");
	private StringProperty codigoCurso = new SimpleStringProperty("");
	private StringProperty nomeCoord = new SimpleStringProperty("");
	private IntegerProperty qtdAlunos = new SimpleIntegerProperty(0);
	private ObjectProperty<LocalDate> dataEnade 
			= new SimpleObjectProperty<>( LocalDate.now() );
	
	
	public void salvar() { 
		System.out.println("Nome curso: " + nomeCurso.get());
		System.out.println("Codigo curso: " + codigoCurso.get());
		System.out.println("Nome coordenador: " + nomeCoord.get());
		System.out.println("Qtd Alunos: " + qtdAlunos.get());
		System.out.println("Data Enade: " + dataEnade.get());
		
		lista.add( 
				new Curso()
					.setId(0)
					.setNomeCurso(nomeCurso.get())
					.setCodCurso(codigoCurso.get())
					.setNomeCoordenador(nomeCoord.get())
					.setQtdAlunos(qtdAlunos.get())
					.setProximoEnade(dataEnade.get()) 
		);
		
	}
	
	public void pesquisar() { 
		String nome = nomeCurso.get();
		for (Curso c : lista) { 
			if (c.getNomeCurso().contains(nome)) { 
				nomeCurso.set( c.getNomeCurso() );
				codigoCurso.set( c.getCodCurso() );
				nomeCoord.set( c.getNomeCoordenador() );
				qtdAlunos.set( c.getQtdAlunos() );
				dataEnade.set( c.getProximoEnade() );
			}
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
	

}
