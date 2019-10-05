import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {
	
	DAOPostgres model;
	TabelaSimples view;
	
	public Controller() {
		
		model = new DAOPostgres();
		view = new TabelaSimples();
		
		view.addBuscaComportamento(new ComportamentoBuscaAluno());
		view.addAdicionaComportamento(new ComportamentoAddAluno());
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

}
