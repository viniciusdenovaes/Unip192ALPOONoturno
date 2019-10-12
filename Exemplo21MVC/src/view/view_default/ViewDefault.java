package view.view_default;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import model.Aluno;
import view.View;

public class ViewDefault implements View {
	
	ActionListener comportamentoBusca;
	ActionListener comportamentoAdicionar;

	@Override
	public void prepare() {
	}

	@Override
	public void init() {
		while(true) {
			System.out.println("Entre com o comando desejado");
			System.out.println("A para adicionar");
			System.out.println("B para buscar");
			System.out.println("X para sair");
			Scanner sc = new Scanner(System.in);
			char acao = sc.next().charAt(0);
			switch(acao) {
			case 'A': 
			case 'a':
				comportamentoAdicionar.actionPerformed(null);
				break;
			case 'B': 
			case 'b':
				comportamentoBusca.actionPerformed(null);
				break;
			case 'X':
			case 'x':
				System.exit(0);
				break;
			default:
				System.out.println("Opcao nao reconhecida");
			}
		}
		
	}

	@Override
	public void addComportamentoBusca(ActionListener al) {
		comportamentoBusca = al;
	}

	@Override
	public String getTextoBusca() {
		System.out.println("Entre com o nome do aluno");
		Scanner sc = new Scanner(System.in);
		String nome = sc.next();
		return nome;
	}

	@Override
	public void exibirAlunos(List<Aluno> alunos) {
		for(Aluno aluno : alunos) {
			System.out.println(aluno);
		}
	}

	@Override
	public void addComportamentoAdicionar(ActionListener al) {
		comportamentoAdicionar = al;
	}

	@Override
	public Aluno getAluno() {
		System.out.println("Entre com os dados do aluno");
		
		System.out.println("Entre com o ra");
		Scanner sc = new Scanner(System.in);
		String ra = sc.next();
		
		System.out.println("Entre com o nome");
		String nome = sc.next();
		
		return new Aluno(ra, nome);
	}

	@Override
	public void exibeResultadoAdicionar(boolean resultado) {
		if(resultado) System.out.println("Aluno adicionado");
		else System.out.println("Aluno nao adicionado");
	}

}
