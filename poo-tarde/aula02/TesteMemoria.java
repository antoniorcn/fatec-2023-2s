public class TesteMemoria { 

	public static void main (String [] args) { 
		String t1 = "João";
		String t2 = "João";
		
		t2 = t2 + "";

		System.out.printf("(%s)\n", t1);
		System.out.printf("(%s)\n", t2);

		if (t1.equals(t2)) { 
			System.out.println("Iguais");		
		} else { 
			System.out.println("Diferentes");
		}
	}
}