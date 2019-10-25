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

import model.Curso;

public class PanelCursos extends JPanel {
	
	JTextField fieldNome = new JTextField(5);
	JButton botaoBuscar = new JButton("Buscar");
	JButton botaoAdicionar = new JButton("Adicionar");
	DefaultTableModel dtm;
	JTable tabela;
	
	public PanelCursos() {
		
		this.setLayout(new BorderLayout(10,10));
		Object[][] data = new Object[0][1];
		Object[] colNames = {"nome"}; 
		dtm = new DefaultTableModel(data, colNames);
		tabela = new JTable(dtm);
		JScrollPane scrollAluno = new JScrollPane(tabela);
		this.add(scrollAluno, BorderLayout.CENTER);
		JPanel panelBotoesAluno = new JPanel();
		panelBotoesAluno.setLayout(new GridLayout(2, 3, 5,5));
		panelBotoesAluno.add(new JLabel(" "));
		panelBotoesAluno.add(new JLabel(" "));
		panelBotoesAluno.add(botaoBuscar);
		panelBotoesAluno.add(new JLabel("Nome"));
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



	public String getNome() {
		return fieldNome.getText();
	}
	public void addComportamentoBusca(ActionListener al) {
		botaoBuscar.addActionListener(al);
	}
	public void addComportamentoAdicionar(ActionListener al) {
		botaoAdicionar.addActionListener(al);
	}
	public void listar(List<Curso> cursos) {
		dtm.setNumRows(0);
		for(Curso curso : cursos) {
			Object[] data = new Object[1];
			data[0] = curso;
			dtm.addRow(data);
		}
		
	}
	
	public Curso getSelecionado() {
		
		int linha = tabela.getSelectedRow();
		Curso curso = (Curso)dtm.getValueAt(linha, 0); 
		
		return curso;
	}
	

}
