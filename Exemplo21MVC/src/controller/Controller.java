package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Aluno;
import model.Dao;
import view.View;

public class Controller {
	
	Dao model;
	View view;
	
	public Controller(Dao model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void init() {
		
		view.prepare();
		
		view.addComportamentoBusca(new ComportamentoBuscaAluno());
		view.addComportamentoAdicionar(new ComportamentoAdicionaAluno());
		
		view.init();
		
	}
	
	class ComportamentoBuscaAluno implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = view.getTextoBusca();
			List<Aluno> alunos = model.buscaAluno(nome);
			view.exibirAlunos(alunos);
		}
	}
	
	class ComportamentoAdicionaAluno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Aluno aluno = view.getAluno();
			boolean resultado = model.adicionaAluno(aluno);
			view.exibeResultadoAdicionar(resultado);
		}
		
	}
	
	
	
	
	
	
	

}
