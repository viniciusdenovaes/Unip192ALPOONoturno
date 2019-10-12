package model;

public class Aluno {
	
	private String ra;
	private String nome;
	
	public Aluno(String ra, String nome) {
		super();
		this.ra = ra;
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + "]";
	}
	
	

}
