package model;

import java.util.Set;

public class Aluno {
	
	private String ra;
	private String nome;
	private Set<Curso> cursos;
	
	public Aluno() {
	}
	
	public Aluno(String ra, String nome) {
		this.ra = ra;
		this.nome = nome;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	
	

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + "]";
	}
	
	

}
