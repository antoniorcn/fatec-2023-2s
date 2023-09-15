public class Pessoa { 

    private String nome;

    public Pessoa() { 
        this("Anonimo");
    }

    public Pessoa(String nome) { 
        super();
        this.nome = nome;
        System.out.println("Criando Pessoa");
    }

    public String getNome() { 
        return this.nome;
    }
}