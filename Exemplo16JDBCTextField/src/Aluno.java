
public class Aluno {
	
	private String ra;
	private String nome;
	
	public Aluno(String aRa, String aNome) {
		this.ra = aRa;
		this.nome = aNome;
	}
	
	@Override
	public String toString() {
		return " ra: " + this.ra + " nome: " + this.nome;
	}

}
