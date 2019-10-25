package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Aluno;
import model.Cadastro;
import model.Curso;
import model.dao.Dao;
import view.View;

public class Controller {
	
	Dao dao;
	View view;
	
	public Controller(Dao dao, View view) {
		this.dao = dao;
		this.view = view;
		
		view.addComportamentoBuscaAluno(new ComportamentoBuscaAluno());
		view.addComportamentoAddAluno(new ComportamentoAddAluno());
		view.addComportamentoBuscaCurso(new ComportamentoBuscaCurso());
		view.addComportamentoAddCurso(new ComportamentoAddCurso());
		view.addComportamentoAddCursoInAluno(new ComportamentoAddCursoInAluno());
	}
	
	
	class ComportamentoBuscaAluno implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = view.getNomeAluno();
			List<Cadastro> cadastros = dao.buscarAlunoByNome(nome);
			view.listarAlunos(cadastros);
		}
	}
	
	class ComportamentoBuscaCurso implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = view.getNomeCurso();
			List<Curso> cursos = dao.buscarCursosByNome(nome);
			view.listarCursos(cursos);
		}
	}
	
	class ComportamentoAddAluno implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String raAluno = view.getRaAluno();
			String nomeAluno = view.getNomeAluno();
			Aluno aluno = new Aluno(raAluno, nomeAluno);
			dao.addAluno(aluno);
		}
	}
	
	
	class ComportamentoAddCurso implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nomeCurso = view.getNomeCurso();
			Curso curso = new Curso(nomeCurso);
			dao.addCurso(curso);
		}
	}
	
	class ComportamentoAddCursoInAluno implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Curso curso = view.getCursoAddCursoInALuno();
			Aluno aluno = view.getAlunoAddCursoInALuno();
			dao.addCursoInAluno(aluno, curso);
		}
	}
	
	

}
