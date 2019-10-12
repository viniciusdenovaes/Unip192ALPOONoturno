package model;

import java.util.List;

public interface Dao {
	
	public List<Aluno> buscaAluno(String nome);
	public boolean adicionaAluno(Aluno aluno);

}
