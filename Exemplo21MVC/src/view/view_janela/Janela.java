package view.view_janela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Janela extends JFrame {
	
	JButton botaoBuscar = new JButton("Buscar");
	JTextField textoBuscaNome = new JTextField(50);
	Object[][] data = new Object[0][2];
	Object[] colNames;
	DefaultTableModel dtm = new DefaultTableModel(data, colNames);
	JTable table = new JTable(dtm);
	JScrollPane scroll = new JScrollPane(table);
	
	JButton botaoAdicionaALuno = new JButton("Adicionar");
	JTextField textoAddNome = new JTextField(50);
	JTextField textoAddRa = new JTextField(50);
	
	
	
	
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		pack();
	}
	

}
