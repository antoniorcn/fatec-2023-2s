package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
    private long id;
    private LocalDate nascimento;
    private String ra;
    private String nome;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public long getId() {
        return this.id;
    }
    public void setId(long valor) {
        this.id = valor;
    }
    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        if (nascimento.isAfter(LocalDate.of(1920, 1, 1))) {
            this.nascimento = nascimento;
        }
    }

    public void setNascimento(String data) {
        LocalDate nascimento = LocalDate.parse( data, dtf );
        setNascimento(nascimento);
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

    @Override
    public String toString() {
        return this.ra + " - " + this.nome;
    }
}
