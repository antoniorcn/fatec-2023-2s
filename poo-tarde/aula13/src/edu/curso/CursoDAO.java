package edu.curso;

import java.util.List;

public interface CursoDAO {
	void salvar(Curso c);
	List<Curso> carregarTodos();
	void apagar(long id);
}
