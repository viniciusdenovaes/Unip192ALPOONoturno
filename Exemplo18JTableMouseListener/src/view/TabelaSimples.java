package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Aluno;

public class TabelaSimples extends JFrame {
	
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table;
	
	JTextField textBusca = new JTextField(50);
	
	JTextField textAddRA = new JTextField(50);
	JTextField textAddNome = new JTextField(50);
	JButton botaoAddAluno = new JButton("Adiciona");
	
	JLabel mostraErro = new JLabel("");
	
	public TabelaSimples() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		
		JPanel controle = new JPanel();
		controle.setLayout(new GridLayout(0, 1));
		add(controle, BorderLayout.PAGE_START);
		
		JPanel panelTextField = new JPanel();
		panelTextField.add(textBusca);
		controle.add(panelTextField);
		
		controle.add(mostraErro);
		
		JPanel panelAddAluno = new JPanel();
		panelAddAluno.setLayout(new GridLayout(0, 1));
		panelAddAluno.add(textAddRA);
		panelAddAluno.add(textAddNome);
		panelAddAluno.add(botaoAddAluno);
		controle.add(panelAddAluno);
		
		
		Object[] colNames = {"Ra", "Nome"};
		Object[][] data = new Object[0][2];
		dtm = new DefaultTableModel(data, colNames);
		
		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) { 
				return false; 
			}
		};
		table.
		JScrollPane scroolPane = new JScrollPane(table);
		add(scroolPane, BorderLayout.CENTER);
		
		
		
		
		pack();
	}
	
	public void mostraAlunos(List<Aluno> alunos) {
		dtm.setNumRows(0);
		for(Aluno aluno : alunos) {
			Object[] data = new Object[2];
			data[0] = aluno.ra;
			data[1] = aluno.nome;
			dtm.addRow(data);
		}
		
	}
	
	public String getNomeBusca() {
		return textBusca.getText();
	}
	
	public void addBuscaComportamento(ActionListener al) {
		textBusca.addActionListener(al);
	}
	
	
	public String getAddRa() {
		return textAddRA.getText();
	}
	
	public String getAddNome() {
		return textAddNome.getText();
	}
	
	public void addAdicionaComportamento(ActionListener al) {
		botaoAddAluno.addActionListener(al);
	}
	
	public void mostraAlunoNaoAdicionado() {
		mostraErro.setText("Aluno Não Adicionado");
	}
	
	public void mostraAlunoAdicionado() {
		mostraErro.setText("Aluno Adicionado");
	}
	
	
	public void addMostraComportamento(MouseListener ml) {
		table.addMouseListener(ml);
	}
	
	public Aluno getAlunoSelecionado() {
		int linhaSelecionada = table.getSelectedRow();
		String ra   = dtm.getValueAt(linhaSelecionada, 0).toString();
		String nome = dtm.getValueAt(linhaSelecionada, 1).toString();
		Aluno aluno = new Aluno(ra, nome);
		return aluno;
	}
	
	public void mostraAluno(Aluno aluno) {
		new JanelaMostraAluno(aluno);
	}
	
	
	
}
