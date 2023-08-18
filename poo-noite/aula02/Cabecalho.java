public class Cabecalho { 

	public static void main (String args[]) { 
		String linha = "";
		for (int i = 0; i < 50; i++) { 
			linha = linha + "#";
		}
		String nome = "Antonio Carvalho";
		int espacos = (48 - nome.length()) / 2;
		String apenasEspacos = "";
		for (int i = 0; i < espacos; i++) { 
			apenasEspacos = apenasEspacos + " ";
		}
		System.out.println(linha);
		System.out.println("#" + apenasEspacos + 
				nome + apenasEspacos + "#");
		System.out.println(linha);
	}

}