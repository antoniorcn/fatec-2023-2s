package edu.curso.assinadas;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class ContatoControl {

    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");

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

    public void salvarContato() { 
        salvar( toEntity() );
        clearBoundary();
    }

    public void procurar() { 
        Contato c = pesquisar( nome.get() );
        fromEntity(c);
    }

    public void clearBoundary() { 
        nome.set("");
        email.set("");
    }

    public Contato toEntity() { 
        Contato c = new Contato();
        c.setNome(nome.get());
        c.setEmail(email.get());
        return c;
    }

    public void fromEntity(Contato c) { 
        if (c != null) { 
            nome.set(c.getNome());
            email.set(c.getEmail());
        } else { 
            Alert a = new Alert(
                AlertType.INFORMATION, 
                    "Contato não encontrado", 
                    new ButtonType("Ok")
            );
            a.show();
        }
    }

    public String getNome() { 
        return this.nome.get();
    }
    public void setNome(String valor) { 
        this.nome.set(valor);
    }
    public StringProperty nomeProperty() { 
        return this.nome;
    }

    public String getEmail() { 
        return this.email.get();
    }
    public void setEmail(String valor) { 
        this.email.set(valor);
    }
    public StringProperty emailProperty() { 
        return this.email;
    }
    
}
