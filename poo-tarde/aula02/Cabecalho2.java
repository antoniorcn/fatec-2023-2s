public class Cabecalho2 { 

	public static void main (String [] args) { 
		StringBuffer linha = new StringBuffer("");

		for (int i = 0; i < 40; i++) { 
			linha.append("#");
		}
		
		System.out.println(linha.toString());

	}
}