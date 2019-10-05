package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import model.Aluno;
import model.DAOPostgres;
import view.TabelaSimples;

public class Controller {
	
	DAOPostgres model;
	TabelaSimples view;
	
	public Controller() {
		
		model = new DAOPostgres();
		view = new TabelaSimples();
		
		view.addBuscaComportamento(new ComportamentoBuscaAluno());
		view.addAdicionaComportamento(new ComportamentoAddAluno());
		view.addMostraComportamento(new ComportamentoMostraAluno());
	}
	
	class ComportamentoBuscaAluno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nome = view.getNomeBusca();
			
			List<Aluno> alunos = model.buscaAlunos(nome);
			
			view.mostraAlunos(alunos);
		}
		
	}
	
	
	class ComportamentoAddAluno implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String ra = view.getAddRa();
			String nome = view.getAddNome();
			
			boolean resultado = model.addAluno(ra, nome);
			if(resultado==false) view.mostraAlunoNaoAdicionado();
			else view.mostraAlunoAdicionado();
			
		}
		
		
	}
	
	class ComportamentoMostraAluno implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				System.out.println("botao clicado duas vezes");
				Aluno aluno = view.getAlunoSelecionado();
				System.out.println("Aluno selecionado: " + aluno);
				view.mostraAluno(aluno);
			}
//			System.out.println("botao clicado");
		}

		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("botao pressionado");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
//			System.out.println("botao solto");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
//			System.out.println("mouse entrou");
		}

		@Override
		public void mouseExited(MouseEvent e) {
//			System.out.println("mouse saiu");
		}
		
	}

}
