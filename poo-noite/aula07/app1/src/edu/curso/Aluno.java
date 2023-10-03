package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
	private long id;
	private String ra;
	private String nome;
	private LocalDate nascimento;
	
	public long getId() { 
		return this.id;
	}
	public void setId(long valor) { 
		this.id = valor;
	}
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public void setNascimento(String sData, 
			DateTimeFormatter dtf) { 
		LocalDate data = LocalDate.parse(sData, dtf);
		setNascimento( data );
	}
	
	@Override
	public String toString() { 
		return this.ra + " - " + this.nome;
	}
}
