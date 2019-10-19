package model.dao;

import java.util.List;

import model.Aluno;
import model.Cadastro;
import model.Curso;

public interface Dao {
	
	List<Cadastro> buscarAlunoByNome(String nome);
	
	List<Curso> buscarCursosByNome(String nome);
	
	boolean addAluno(Aluno aluno);
	
	boolean addCurso(Curso curso);
	
	boolean addCursoInAluno(Aluno aluno, Curso curso);

}
