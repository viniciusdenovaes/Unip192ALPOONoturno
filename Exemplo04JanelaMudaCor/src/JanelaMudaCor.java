import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaMudaCor extends JFrame{
	
	JPanel panel = new JPanel();
	
	public JanelaMudaCor() {
		
		setLayout(new FlowLayout());
		
		JButton botao = new JButton("Amarelo");
		botao.addActionListener(new ComportamentoBotao());
		panel.add(botao);
		
		panel.setPreferredSize(
				new Dimension(400, 600));
		
		add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setSize(600, 650);
		//pack();
		
	}
	
	class ComportamentoBotao implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("botao clicado");
			panel.setBackground(Color.YELLOW);
		}
		
	}

}
