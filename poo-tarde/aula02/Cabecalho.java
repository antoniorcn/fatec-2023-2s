
public class Cabecalho { 
	public static void main(String args[]) { 
		String linha = "";
		for (int i = 0; i < 50; i++) { 
			linha += "#";
		}	
		String nome = "Antonio Rodrigues";
		int qtd = (48 - nome.length()) / 2;
		String format = "#%-" + qtd  + "s%s%"
				 + (qtd + 1) + "s#\n";
		System.out.println(format);
		System.out.printf(linha + "\n");
		System.out.printf(format, " ", nome, " ");
		System.out.printf(linha + "\n");
	}
}