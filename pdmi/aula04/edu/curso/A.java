package edu.curso;
public class A { 
	private int x;
	private B b;

	public int getX() { 
		return this.x;
	}

	public void setX( int valor ) { 
		this.x = valor;
		b.alterado();
	}

	public B getB() { 
		return this.b;
	}

	public void setB(B valor) { 
		this.b = valor;
	}

	public void alterado() { 
		System.out.println("Alterado da classe A foi executado");
	}

}