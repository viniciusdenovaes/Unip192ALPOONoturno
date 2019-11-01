package teste;

import dao.DaoHibernate;
import model.Aluno;
import model.Curso;

public class Teste {
	
	public static void main(String[] args) {
		
		DaoHibernate dao = new DaoHibernate();
		
		Aluno aluno01 = new Aluno("128", "Elaine");
		Aluno aluno02 = new Aluno("129", "Fernanda");
		
		//dao.addAluno(aluno01);
		
		for(Aluno aluno : dao.getAllAlunos()) {
			System.out.println(aluno);
			System.out.println("Cursos: ");
			for(Curso curso : aluno.getCursos())
				System.out.println(curso);
		}
		
	}

}
