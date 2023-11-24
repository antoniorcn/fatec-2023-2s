package edu.curso.produto;

public class Produto {
	private String codigo;
	private String nome;
	private double preco;

	public String getNome() { 
		return this.nome;
	}
	public void setNome(String valor) { 
		this.nome = valor;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
