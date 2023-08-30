public class TesteAluno { 

    public static void main(String[] args) { 
        Aluno a1 = new Aluno();
        a1.setNome("João Silva");
        a1.setRa("1111");
        
        Disciplina d1 = new Disciplina();
        d1.setTitulo("Inglês II");

        a1.adicionarAssinante(d1);

        a1.matricular();

    }
}