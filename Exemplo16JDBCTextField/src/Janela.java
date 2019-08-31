import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame {
	
	JTextField textBusca;
	
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new GridLayout(2, 1));
		
		textBusca = new JTextField(50);
		textBusca.addActionListener(new ComportamentoBusca());
		add(textBusca);
		
		JPanel panelBotao = new JPanel();
		JButton botaoBusca = new JButton("Buscar");
		botaoBusca.addActionListener(new ComportamentoBusca());
		panelBotao.setLayout(
				new BoxLayout(
						panelBotao, BoxLayout.LINE_AXIS));
		panelBotao.add(Box.createHorizontalGlue());
		panelBotao.add(botaoBusca);
		add(panelBotao);
		
		pack();
	}
	
	class ComportamentoBusca implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nome = textBusca.getText();
			
			ArrayList<Aluno> alunos = 
					MyConnection.buscaAlunos(nome);
			
			for(Aluno aluno : alunos) {
				System.out.println(aluno);
			}
		}
		
	}

}
