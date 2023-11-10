package edu.curso;

import java.time.LocalDate;

public class Cliente {
	
	private long id;
	private String nome;
	private String cpf;
	private int milhas;
	private LocalDate nascimento;
	
	public long getId() { 
		return this.id;
	}
	public void setId(long valor) { 
		this.id = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getMilhas() {
		return milhas;
	}
	public void setMilhas(int milhas) {
		this.milhas = milhas;
	}
	
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
}
