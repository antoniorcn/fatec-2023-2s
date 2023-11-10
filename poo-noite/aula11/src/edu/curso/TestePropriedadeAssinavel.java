package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

class Aluno { 
//	private String disciplina = "";
//	public String getDisciplina() { 
//		return disciplina;
//	}
//	public void setDisciplina(String valor) { 
//		this.disciplina = valor;
//	}
	
	private StringProperty disciplina = new SimpleStringProperty("");
	
	public String getDisciplina() { 
		return disciplina.get();
	}
	public void setDisciplina(String valor) { 
		this.disciplina.set(valor);
	}
	public StringProperty disciplinaProperty() { 
		return this.disciplina;
	}
}

public class TestePropriedadeAssinavel {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
	
		a1.disciplinaProperty().addListener(
				(obs, antigo, novo) -> {
					System.out.println("Disciplina foi troca de " + 
				antigo + " para " + novo);
				}
		);
		
		a1.setDisciplina("POO");
		a1.setDisciplina("LES");
		a1.setDisciplina("ENG SW II");
		
	}
	
}
