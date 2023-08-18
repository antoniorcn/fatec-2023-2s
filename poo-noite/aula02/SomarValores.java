import java.util.Scanner;
public class SomarValores { 
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite um numero: ");
		int n1 = scan.nextInt();
		System.out.println("Digite outro numero: ");
		int n2 = scan.nextInt();
		int total = n1 + n2;
		System.out.println("Total : " + total);
	}
}