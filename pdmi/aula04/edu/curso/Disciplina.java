public class Disciplina implements Assinante { 
    private String titulo;

    public String getTitulo() { 
        return this.titulo;
    }

    public void setTitulo(String valor) { 
        this.titulo = valor;
    }

    public void notificado() { 
      System.out.println("Vaga preenchida");
   }
}