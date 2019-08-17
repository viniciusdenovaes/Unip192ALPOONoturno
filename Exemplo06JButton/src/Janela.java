import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame {
	
	public Janela() {
		setTitle("Janela com um botao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		
		JButton botao = new JButton("Clique aqui");
		botao.addActionListener(new ComportamentoBotao());
		add(botao);
		
		JButton outroBotao = new JButton("Nao clique aqui");
		outroBotao.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						botao.setEnabled(false);
						outroBotao.setEnabled(false);
					}
				});
		add(outroBotao);
		
		
		pack();
	}
	
	
	class ComportamentoBotao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("botao clicado");
		}
	}
	
}
