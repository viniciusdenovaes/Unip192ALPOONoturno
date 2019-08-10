import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaTrocaCor extends JFrame {
	
	public JanelaTrocaCor() {
		setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(
				new BotaoTrocaCor(
						Color.YELLOW, "Amarelo", panel));
		panel.add(
				new BotaoTrocaCor(
						Color.GREEN, "Verde", panel));
		panel.add(
				new BotaoTrocaCor(
						Color.CYAN, "Ciano", panel));
		
		add(panel);
		
		panel.setPreferredSize(new Dimension(200, 400));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

}
