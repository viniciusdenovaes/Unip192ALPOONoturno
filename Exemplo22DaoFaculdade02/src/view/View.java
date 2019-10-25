package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Aluno;
import model.Cadastro;
import model.Curso;

public class View extends JFrame {
	
	PanelAlunos panelAlunos = new PanelAlunos();
	PanelCursos panelCursos = new PanelCursos();
	
	JButton botaoCadastrar = new JButton("Cadastrar");
	JButton botaoMostrar = new JButton("Mostrar");
	
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel panelTabelas = new JPanel();
		JPanel panelBotoes = new JPanel();
		add(panelTabelas, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.PAGE_END);
		
		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBotoes.add(botaoMostrar);
		panelBotoes.add(botaoCadastrar);
		
		panelTabelas.setLayout(
				new BoxLayout(panelTabelas, BoxLayout.LINE_AXIS));
		
		
		panelTabelas.add(panelAlunos);
		panelTabelas.add(panelCursos);
		
		panelAlunos.getTabela().addMouseListener(new ComportamentoMostrarCadastro());
		
		pack();
	}
	
	public String getRaAluno() {
		return panelAlunos.fieldRa.getText();
	}
	public String getNomeAluno() {
		return panelAlunos.fieldNome.getText();
	}
	public void addComportamentoBuscaAluno(ActionListener al) {
		panelAlunos.botaoBuscar.addActionListener(al);
	}
	public void addComportamentoAddAluno(ActionListener al) {
		panelAlunos.addComportamentoAdicionar(al);
	}
	public void listarAlunos(List<Cadastro> cadastros) {
		panelAlunos.listar(cadastros);
	}
	
	
	public String getNomeCurso() {
		return panelCursos.getNome();
	}
	public void addComportamentoBuscaCurso(ActionListener al) {
		panelCursos.addComportamentoBusca(al);
	}
	public void addComportamentoAddCurso(ActionListener al) {
		panelCursos.addComportamentoAdicionar(al);
	}
	public void listarCursos(List<Curso> cursos) {
		panelCursos.listar(cursos);
		
	}
	
	
	public void addComportamentoAddCursoInAluno(ActionListener al) {
		botaoCadastrar.addActionListener(al);
		
	}
	public Aluno getAlunoAddCursoInALuno() {
		return panelAlunos.getSelecionado();
	}
	public Curso getCursoAddCursoInALuno() {
		return panelCursos.getSelecionado();
	}
	
	
	class ComportamentoMostrarCadastro implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				int row = panelAlunos.getTabela().getSelectedRow();
				Cadastro cadastro = (Cadastro)panelAlunos.getDtm().getValueAt(row, 0);
				JFrame janelaMostra = new JFrame("Aluno");
				janelaMostra.setLayout(
						new BoxLayout(janelaMostra.getContentPane(), BoxLayout.PAGE_AXIS));
				janelaMostra.add(new JLabel("Ra: " + cadastro.getAluno().getRa()));
				janelaMostra.add(new JLabel("Nome: " + cadastro.getAluno().getNome()));
				janelaMostra.add(new JLabel("Cursos: "));
				for(Curso curso : cadastro.getCursos())
					janelaMostra.add(new JLabel("    " + curso.getNome()));
				janelaMostra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				janelaMostra.setVisible(true);
				janelaMostra.pack();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
