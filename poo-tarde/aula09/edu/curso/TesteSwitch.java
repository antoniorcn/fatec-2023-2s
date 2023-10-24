package edu.curso;
import java.util.Scanner;
public class TesteSwitch { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char opcao = 'L';
        char teste = 10;
        System.out.println(teste);
        // double d = input.nextDouble();
        System.out.println("Digite algo");
        System.out.println(input.next());
        // System.out.println("Numero: " + d);
        switch(opcao){
            case 'C' -> System.out.println("Cadastro");
            case 'L' -> System.out.println("Listar");
            case 'S' -> System.out.println("Sair");
        }
        input.close();
    }
}