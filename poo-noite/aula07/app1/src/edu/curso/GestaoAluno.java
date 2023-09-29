package edu.curso;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestaoAluno {
	public static final int MAX_SIZE = 50;
	private int indice;
	private Aluno[] alunos = new Aluno[MAX_SIZE];
	private Scanner input = new Scanner(System.in);
	private	DateTimeFormatter dtf = 
		DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public void criar() { 
		if (indice < MAX_SIZE) { 
			Aluno a = new Aluno();
			System.out.println("Criando um novo Aluno");
			System.out.println("Digite o nome completo: ");
			a.setNome(input.nextLine());
			System.out.println("Digite o RA: ");
			a.setRa(input.nextLine());
			System.out.println("Digite a data de nascimento: ");
			String sData = input.nextLine();
			a.setNascimento(sData, dtf);
			a.setId(indice);
			alunos[indice] = a;
			indice++;
		} else { 
			System.out.println("Não há memória suficiente para cadastrar novo aluno");
		}
	}
	
	public int pesquisar(String ra) { 
		for (int i = 0; i < MAX_SIZE; i++) { 
			Aluno a = alunos[i];
			if (a != null) { 
				if (ra.equals(a.getRa())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void exibir() { 
		System.out.println("Exibir detalhes de aluno");
		System.out.println("Por favor informe o ra do aluno a ser exibido");
		String ra = input.nextLine();
		int i = pesquisar(ra);
		if (i != -1) {
			Aluno a = alunos[i];
			System.out.println("Id: " + a.getId());
			System.out.println("Ra: " + a.getRa());
			System.out.println("Nome: " + a.getNome());
			System.out.println("Nascimento: " + a.getNascimento());
		} else { 
			System.out.println("Aluno não encontrado");
		}
	}
	
	public void excluir() { 
		System.out.println("Excluir aluno");
		System.out.println("Por favor informe o ra do aluno a ser excluido");
		String ra = input.nextLine();
		int i = pesquisar(ra);
		if (i != -1) {
			alunos[i] = null;
		}
	}
	
	public void atualizar() { 
		System.out.println("Atualizar aluno");
		System.out.println("Por favor informe o ra do aluno a ser atualizado");
		String ra = input.nextLine();
		int i = pesquisar(ra);
		if (i != -1) {
			Aluno a = alunos[i];
			System.out.println("Digite o novo nome completo: ");
			a.setNome(input.nextLine());
			System.out.println("Digite o novo RA: ");
			a.setRa(input.nextLine());
			System.out.println("Digite a nova data de nascimento: ");
			String sData = input.nextLine();
			a.setNascimento(sData, dtf);
		}
	}
	
	public void listar() { 
		for (int i = 0; i < MAX_SIZE; i++) { 
			Aluno a = alunos[i];
			if (a != null) { 
				System.out.println(a);
			}
		}
	}
	
	public void menu() { 
		while(true) { 
			System.out.println("Gestão de Alunos");
			System.out.println("(C)riar novo aluno");
			System.out.println("(E)xibir aluno");
			System.out.println("(A)tualizar aluno");
			System.out.println("(R)emover aluno");
			System.out.println("(L)istar aluno");
			System.out.println("(S)air");
			char opcao = input.nextLine().toUpperCase().charAt(0);
			if (opcao == 'C') { 
				criar();
			} else if (opcao == 'E') {
				exibir();
			} else if (opcao == 'A') {
				atualizar();
			} else if (opcao == 'R') {
				excluir();
			} else if (opcao == 'L') {
				listar();
			} else if (opcao == 'S') {
				System.out.println("Ate breve...!!!!");
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		GestaoAluno ga = new GestaoAluno();
		ga.menu();
	}
}
