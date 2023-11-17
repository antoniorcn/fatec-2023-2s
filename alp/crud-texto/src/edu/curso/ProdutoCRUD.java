package edu.curso;

import java.util.Scanner;

public class ProdutoCRUD {
	public static int MAX_PRODUTOS = 100;
	public static Produto[] produtos = new Produto[MAX_PRODUTOS];
	public static Scanner input = new Scanner(System.in);
	public static int indice = 0;
	
	public static void cadastrar() { 
		System.out.println("CADASTRAR PRODUTO");
		System.out.println("Digite os dados do produto");
		System.out.println("Digite o nome do produto: ");
		String nome = input.nextLine();
		System.out.println("Digite o preço do produto");
		double preco = input.nextDouble();
		input.nextLine();
		Produto p = new Produto();
		p.nome = nome;
		p.preco = preco;
		p.id = indice + 1;
		produtos[indice] = p;
		indice = indice + 1; // indice += 1  ou indice++ ou ++indice
	}
	
	public static void procurar() { 
		System.out.println("PROCURAR PRODUTO");
		System.out.println("Digite o nome do produto a ser procurado: ");
		String nome = input.nextLine();
		for (int i = 0; i < indice; i++) { 
			Produto p = produtos[i];
			if (p != null && p.nome.contains(nome)) { 
				System.out.println("Produto Encontrado");
				System.out.println("Nome: " + p.nome);
				System.out.println("Preço: " + p.preco);
				// break;
			}
		}
	}
	
	public static void alterar() { 
		System.out.println("ALTERAR PRODUTO");
		System.out.println("Digite o nome do produto a ser alterado: ");
		String nome = input.nextLine();
		for (int i = 0; i < indice; i++) { 
			Produto p = produtos[i];
			if (p != null && p.nome.equalsIgnoreCase(nome)) {
				System.out.println("Digite o novo nome do produto: ");
				p.nome = input.nextLine();
				System.out.println("Digite o novo preço do produto");
				p.preco = input.nextDouble();
				input.nextLine();
				System.out.println("Produto Alterado com sucesso...");
				break;
			}
		}
	}
	
	public static void remover() { 
		System.out.println("REMOVER PRODUTO");
		System.out.println("Digite o nome do produto a ser removido: ");
		String nome = input.nextLine();
		for (int i = 0; i < indice; i++) { 
			Produto p = produtos[i];
			if (p != null && p.nome.equalsIgnoreCase(nome)) {
				produtos[i] = null;
				break;
			}
		}
	}
	
	public static void listar() { 
		System.out.println("Nome\t\tPreço");
		for (int i = 0; i < indice; i++) { 
			Produto p = produtos[i];
			if (p != null) { 
				System.out.println(p.nome + "\t\t" + p.preco);
			}
		}
	}
	
	public static void menu() { 
		boolean terminar = false;
		while (!terminar) {
			System.out.println("GESTÃO DE PRODUTOS");
			System.out.println("(C)adastrar");
			System.out.println("(P)rocurar");
			System.out.println("(A)lterar");
			System.out.println("(R)emover");
			System.out.println("(L)istar");
			System.out.println("(S)air");
			System.out.println("Por favor escolha uma opção: ");
			String escolha = input.nextLine();
			if (escolha.length() > 0) { 
				char op = escolha.toLowerCase().charAt(0);
				if (op == 'c') { 
					cadastrar();
				} else if (op == 'p') {
					procurar();
				} else if (op == 'a') {
					alterar();
				} else if (op == 'r') {
					remover();		
				} else if (op == 'l') {
					listar();						
				} else if (op == 's') { 
					System.out.println("Até logo...");
					terminar = true;
				}
			}
		}

		
		
		//if (escolha.equalsIgnoreCase("C")) { 
		//			cadastrar();
		//		}
	}
	
	public static void main(String[] args) { 
		menu();
	}
	
	public static void teste() { 
//		Produto p1 = new Produto();
//		p1.nome = "Carro";
//		p1.preco = 50000;
//		p1.id = 1;
//		
//		produtos[0] = p1;
//		
//		Produto p2 = new Produto();
//		p2.nome = "Moto";
//		p2.preco = 8000;
//		p2.id = 2;
//		
//		produtos[1] = p2;
	}
}
