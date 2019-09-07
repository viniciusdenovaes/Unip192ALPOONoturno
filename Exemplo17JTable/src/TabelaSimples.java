import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TabelaSimples extends JFrame {
	
	static String URL = "jdbc:postgresql:Faculdade";
	static String USER = "postgres";
	static String PASS = "123456";
	
	DefaultTableModel dtm = new DefaultTableModel();
	JTextField textBusca = new JTextField(50);
	
	public TabelaSimples() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		JPanel panelTextField = new JPanel();
		panelTextField.add(textBusca);
		textBusca.addActionListener(new ComportamentoBusca());
		add(panelTextField, BorderLayout.PAGE_START);
		
		String query = "SELECT * FROM alunos";
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);
			ArrayList<Aluno> alunos = new ArrayList<>();
			while(rs.next()) {
				String ra = rs.getString("ra");
				String nome = rs.getString("nome");
				alunos.add(new Aluno(ra, nome));
			}
			
			Object[][] dados = new Object[alunos.size()][2];
			for(int i=0; i<alunos.size(); i++) {
				dados[i][0] = alunos.get(i).ra;    //alunos[i].ra
				dados[i][1] = alunos.get(i).nome;
			}
			
			Object[] colsNames = {"ra", "nome"};
			dtm = new DefaultTableModel(dados, colsNames);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		JTable table = new JTable(dtm);
		JScrollPane scroolPane = new JScrollPane(table);
		add(scroolPane, BorderLayout.CENTER);
		
		
		
		
		pack();
	}
	
	void atualizaTabela(String nome) {
		String query = 
				"SELECT * FROM alunos "
				+ "WHERE LOWER(nome) LIKE LOWER(?)";
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%"+nome+"%");
			ResultSet rs = pstm.executeQuery();
			dtm.setRowCount(0);   // Limpa a table, 
			                      //quantidade de linhas para zero
			while(rs.next()) {
				Object[] rowData = new Object[2];
				rowData[0] = rs.getString(1);
				rowData[1] = rs.getString(2);
				dtm.addRow(rowData);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	class ComportamentoBusca implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = textBusca.getText();
			atualizaTabela(nome);
		}
		
	}
	
	
}
