import java.util.List;
import java.util.ArrayList;

public class Aluno implements Publicadora { 

    private String nome;
    private String ra;
    // private Disciplina disciplina;

    private List<Assinante> assinantes = 
            new ArrayList<>();

    public void adicionarAssinante(Assinante a) { 
        assinantes.add(a);
    }

    public void removerAssinante(Assinante a) { 
        assinantes.remove(a);
    }

    public String getNome() { 
        return this.nome;
    }

    public void setNome(String valor) { 
        this.nome = valor;
    }

    public String getRa() { 
        return this.ra;
    }

    public void setRa(String valor) { 
        this.ra = valor;
    }

    // public Disciplina getDisciplina() { 
    //     return this.disciplina;
    // }

    // public void setDisciplina(Disciplina valor) { 
    //     this.disciplina = valor;
    // }

    public void matricular() { 
        System.out.println(
            "Aluno matriculado na disciplina "); 
                // disciplina.getTitulo());
        // disciplina.vagaPreenchida();
        notificar();
    }

    public void notificar() { 
        for (Assinante a : assinantes) { 
            a.notificado();
        }
    }

}