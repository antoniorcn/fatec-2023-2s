package edu.curso;
public class Teste { 
	public static void main(String args[]) {
		System.out.println("Executando Teste");
		A a1 = new A();

		B b1 = new B();

		a1.setB(b1);
		a1.setX(50);

		System.out.println("Teste finalizado");
	}
}