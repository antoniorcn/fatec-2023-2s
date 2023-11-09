package edu.curso;

import java.time.LocalDate;

public class Teste {

	public static void main(String[] args) {
		LocalDate dt = LocalDate.of(2024, 12, 10);
		
		Curso c = new Curso()
		.setId(1l)
		.setNomeCurso("ADS")
		.setNomeCoordenador("Luciano")
		.setProximoEnade(dt);
		// Padrão de projetos Fluence
		
	}
}
