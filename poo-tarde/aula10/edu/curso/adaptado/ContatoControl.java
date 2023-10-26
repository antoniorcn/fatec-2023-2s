package edu.curso.adaptado;

import java.util.ArrayList;
import java.util.List;

public class ContatoControl {

    private List<Contato> lista = new ArrayList<>();

    public void salvar( Contato c ) { 
        lista.add(c);
        System.out.println("Tamanho Lista: " + lista.size());
    }

    public Contato pesquisar( String texto ) { 
        for (Contato c : lista) { 
            if (c.getNome().contains(texto)) { 
                return c;
            }
        }
        return null;
    }
    
}
