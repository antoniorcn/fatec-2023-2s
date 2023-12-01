package edu.curso;

import java.util.List;

public interface AlunoDAO {
	
	void salvar(Aluno a);
	List<Aluno> lerTodos();
	List<Aluno> pesquisarNome(String nome);

}
