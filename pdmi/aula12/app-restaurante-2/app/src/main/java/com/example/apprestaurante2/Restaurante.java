package com.example.apprestaurante2;

import java.io.Serializable;

public class Restaurante implements Serializable {

    private long id;
    private String nome;
    private String endereco;
    private String tipo;
    private int classe;
    private double latitude;
    private double longitude;

    private String descricao;

    private String chave;

    public Restaurante() {

    }

    public Restaurante(String nome, String tipo, int classe) {
        this.nome = nome;
        this.tipo = tipo;
        this.classe = classe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getChave() {
        return chave;
    }
    public void setChave(String chave) {
        this.chave = chave;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.tipo + " - " + this.classe;
    }

}