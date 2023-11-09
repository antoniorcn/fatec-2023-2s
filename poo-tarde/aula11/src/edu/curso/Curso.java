package edu.curso;

import java.time.LocalDate;

public class Curso {
	
	private long id;
	private String nomeCurso;
	private String codCurso;
	private String nomeCoordenador;
	private int qtdAlunos;
	private LocalDate proximoEnade;
	
	public long getId() { 
		return this.id;
	}
	public Curso setId(long valor) { 
		this.id = valor;
		return this;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}
	public Curso setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
		return(this);
	}

	public String getCodCurso() {
		return codCurso;
	}
	public Curso setCodCurso(String codCurso) {
		this.codCurso = codCurso;
		return(this);
	}

	public String getNomeCoordenador() {
		return nomeCoordenador;
	}
	public Curso setNomeCoordenador(String nomeCoordenador) {
		this.nomeCoordenador = nomeCoordenador;
		return(this);
	}

	public int getQtdAlunos() {
		return qtdAlunos;
	}
	public Curso setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
		return(this);
	}

	public LocalDate getProximoEnade() {
		return proximoEnade;
	}
	public Curso setProximoEnade(LocalDate proximoEnade) {
		this.proximoEnade = proximoEnade;
		return(this);
	}
}
