package model;

public class Curso {
	
	private String nome;

	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + "]";
	}
	
	

}
