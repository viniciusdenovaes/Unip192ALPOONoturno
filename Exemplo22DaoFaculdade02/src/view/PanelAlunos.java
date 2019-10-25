package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Aluno;
import model.Cadastro;
import model.Curso;

public class PanelAlunos extends JPanel {
	
	JTextField fieldRa = new JTextField(5);
	JTextField fieldNome = new JTextField(5);
	JButton botaoBuscar = new JButton("Buscar");
	JButton botaoAdicionar = new JButton("Adicionar");
	DefaultTableModel dtm;
	JTable tabela;
	
	public PanelAlunos() {
		
		this.setLayout(new BorderLayout(10,10));
		Object[][] data = new Object[0][2];
		Object[] colNames = {"ra", "nome"}; 
		dtm = new DefaultTableModel(data, colNames);
		tabela = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		JScrollPane scrollAluno = new JScrollPane(tabela);
		this.add(scrollAluno, BorderLayout.CENTER);
		JPanel panelBotoesAluno = new JPanel();
		panelBotoesAluno.setLayout(new GridLayout(2, 3, 5,5));
		panelBotoesAluno.add(new JLabel("ra"));
		panelBotoesAluno.add(fieldRa);
		panelBotoesAluno.add(botaoBuscar);
		panelBotoesAluno.add(new JLabel("nome"));
		panelBotoesAluno.add(fieldNome);
		panelBotoesAluno.add(botaoAdicionar);
		this.add(panelBotoesAluno, BorderLayout.PAGE_END);
	}
	
	
	
	public DefaultTableModel getDtm() {
		return dtm;
	}



	public JTable getTabela() {
		return tabela;
	}



	public String getRa() {
		return fieldRa.getText();
	}
	public String getNome() {
		return fieldNome.getText();
	}
	public void addComportamentoBusca(ActionListener al) {
		botaoBuscar.addActionListener(al);
	}
	public void addComportamentoAdicionar(ActionListener al) {
		botaoAdicionar.addActionListener(al);
	}
	public void listar(List<Cadastro> cadastros) {
		dtm.setNumRows(0);
		for(Cadastro cadastro : cadastros) {
			Object[] data = new Object[2];
			data[0] = cadastro;
			data[1] = cadastro.getAluno().getNome();
			dtm.addRow(data);
		}
		
	}
	
	public Aluno getSelecionado() {
		int linha = tabela.getSelectedRow();
		Cadastro cadastro = (Cadastro)dtm.getValueAt(linha, 0);
		Aluno aluno = cadastro.getAluno();
		return aluno;
	}
	

	

}
