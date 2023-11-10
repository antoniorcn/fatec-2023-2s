package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class ClienteControl {
	
	private List<Cliente> lista = new ArrayList<>();
	
	public void salvar( Cliente c ) { 
		lista.add(c);
	}
	
	public Cliente procurar( String nome ) { 
		for (int i = 0; i < lista.size(); i++) { 
			Cliente c = lista.get(i);
			if (c.getNome().contains(nome)) { 
				return c;
			}
		}
		return null;
	}

}
