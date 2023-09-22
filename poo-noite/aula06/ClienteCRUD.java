public class ClienteCRUD { 

    public Gravador gravador = 
            new GravarArquivo();

    public void apertarBotao() { 
        gravador.gravar();
    }

}