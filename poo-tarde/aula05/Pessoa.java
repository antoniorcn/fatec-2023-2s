public class Pessoa { 
    private String nome;
    private int idade;

    // public Pessoa() { 
    //     this("José Silva");
    // }

    public Pessoa(String nome) {
        this(nome, 18);
    }

    public Pessoa(String nome, int idade) { 
        this.nome = nome;
        this.idade = idade;
        System.out.println("Pessoa criada");
    }

    public String getNome() { 
        return this.nome;
    }

}