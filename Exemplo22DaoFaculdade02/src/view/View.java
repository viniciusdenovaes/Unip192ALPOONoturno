package view;

import java.awt.BorderLayout;
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
	
	JPanel panelAluno = new JPanel();
	JTextField fieldRaAluno = new JTextField(5);
	JTextField fieldNomeAluno = new JTextField(5);
	JButton botaoBuscarAluno = new JButton("Buscar");
	JButton botaoAdicionarAluno = new JButton("Adicionar");
	DefaultTableModel dtmAluno;
	JTable tabelaAluno;
	
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel panelTabelas = new JPanel();
		JPanel panelBotoes = new JPanel();
		add(panelTabelas, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.PAGE_END);
		
		
		panelTabelas.add(panelAluno);
		panelAluno.setLayout(new BorderLayout(10,10));
		Object[][] dataAluno = new Object[0][2];
		Object[] colNamesAluno = {"ra", "nome"}; 
		dtmAluno = new DefaultTableModel(dataAluno, colNamesAluno);
		tabelaAluno = new JTable(dtmAluno);
		JScrollPane scrollAluno = new JScrollPane(tabelaAluno);
		panelAluno.add(scrollAluno, BorderLayout.CENTER);
		JPanel panelBotoesAluno = new JPanel();
		panelBotoesAluno.setLayout(new GridLayout(2, 3, 5,5));
		panelBotoesAluno.add(new JLabel("ra"));
		panelBotoesAluno.add(fieldRaAluno);
		panelBotoesAluno.add(botaoBuscarAluno);
		panelBotoesAluno.add(new JLabel("nome"));
		panelBotoesAluno.add(fieldNomeAluno);
		panelBotoesAluno.add(botaoAdicionarAluno);
		panelAluno.add(panelBotoesAluno, BorderLayout.PAGE_END);
		
		tabelaAluno.addMouseListener(new ComportamentoMostrarCadastro());
		
		pack();
	}
	
	public String getRaAluno() {
		return fieldRaAluno.getText();
	}
	public String getNomeAluno() {
		return fieldNomeAluno.getText();
	}
	public void addComportamentoBuscaAluno(ActionListener al) {
		botaoBuscarAluno.addActionListener(al);
	}
	public void addComportamentoAddAluno(ActionListener al) {
		
	}
	public void listarAlunos(List<Cadastro> cadastros) {
		dtmAluno.setNumRows(0);
		for(Cadastro cadastro : cadastros) {
			Object[] data = new Object[2];
			data[0] = cadastro;
			data[1] = cadastro.getAluno().getNome();
			dtmAluno.addRow(data);
		}
		
		for(Cadastro cadastro : cadastros) {
			System.out.println(cadastro.getAluno());
			for(Curso curso : cadastro.getCursos()) {
				System.out.println(curso);
			}
		}
	}
	
	
	public String getNomeCurso() {
		return null;
	}
	public void addComportamentoBuscaCurso(ActionListener al) {
		
	}
	public void addComportamentoAddCurso(ActionListener al) {
		
	}
	public void listarCursos(List<Curso> cursos) {
		
	}
	
	
	public void addComportamentoAddCursoInAluno(ActionListener al) {
		
	}
	public Aluno getAlunoAddCursoInALuno() {
		return null;
	}
	public Curso getCursoAddCursoInALuno() {
		return null;
	}
	
	
	class ComportamentoMostrarCadastro implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tabelaAluno.getSelectedRow();
			Cadastro cadastro = (Cadastro)dtmAluno.getValueAt(row, 0);
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
