package model;

public class Aluno {
	
	public String ra;
	public String nome;
	public Aluno(String ra, String nome) {
		super();
		this.ra = ra;
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + "]";
	}
	

}
