import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {
	
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JButton b1 = new JButton("botao 1");
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 205;
		panel.add(b1, c);
		
		JButton b2 = new JButton("botao 2");
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 0;
		panel.add(b2, c);
		
		JButton b3 = new JButton("botao 3");
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(10, 20, 30, 40);
		panel.add(b3, c);
		
		JButton b4 = new JButton("botao 4");
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		panel.add(b4, c);
		
		JButton b5 = new JButton("botao 5");
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		panel.add(b5, c);
		
		add(panel);
		pack();
	}

}
