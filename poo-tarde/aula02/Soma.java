import java.util.Scanner;
public class Soma { 

	public static void main(String args[]) { 
		Scanner scan = new Scanner(System.in);
		System.out.printf("Digite um numero: ");
		int n1 = scan.nextInt();
		System.out.printf("Digite outro numero: ");
		int n2 = scan.nextInt();
		
		int soma = n1 + n2;
		System.out.println("Soma :" + soma);
	}
}