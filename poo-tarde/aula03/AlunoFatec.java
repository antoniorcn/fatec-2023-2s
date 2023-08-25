public class AlunoFatec { 
    public String nomeCompleto;
    public String ra;
    public int idade = 17;

    public void dormirPouco(int horasSono) {
        System.out.println("Estou dormindo");
    }

    public void estudarMuito() { 
        System.out.println("Estudando...");
    }

    public void imprimirDados() { 
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("RA: " + ra);
        System.out.println("Idade: " + idade);
    }

    public static void teste() { 
        int mes = 0;
        System.out.println("Testando ....");
        System.out.println("Idade: " + mes);
    }
}