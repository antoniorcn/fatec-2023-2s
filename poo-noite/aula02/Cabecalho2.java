public class Cabecalho2 { 

	public static void main (String args[]) { 
		String linha = "";
		for (int i = 0; i < 50; i++) { 
			linha = linha + "#";
		}
		String nome = "Antonio Carvalho";
		int espacos = (48 - nome.length()) / 2;
		System.out.println(linha);
		System.out.printf("#%" + espacos + 
			"s%s%" + espacos + 
			"s#\n", "", nome, "");
		System.out.println(linha);
	}

}