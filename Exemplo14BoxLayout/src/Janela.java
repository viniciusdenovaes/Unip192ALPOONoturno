import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Janela extends JFrame {
	
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.PINK);
		add(panelCentral, BorderLayout.CENTER);
		
		panelCentral.setLayout(
				new BoxLayout(
						panelCentral, BoxLayout.PAGE_AXIS));
		JLabel label = new JLabel("label ");
		
		JPanel panelLabel = new JPanel();
		panelLabel.setLayout(new FlowLayout(FlowLayout.LEADING));
		panelLabel.setBackground(Color.BLUE);
		panelLabel.add(label);
		
		panelCentral.add(panelLabel);
		JTextArea textArea = new JTextArea(20, 20);
		panelCentral.add(textArea);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(Color.GREEN);
		add(panelBotoes, BorderLayout.PAGE_END);
		panelBotoes.setLayout(
				new BoxLayout(
						panelBotoes, BoxLayout.LINE_AXIS));
		panelBotoes.add(Box.createHorizontalGlue());
		JButton botaoCancel = new JButton("Cancel");
		panelBotoes.add(botaoCancel);
		panelBotoes.add(
				Box.createRigidArea(new Dimension(10, 0)));
		JButton botaoOk = new JButton("Ok");
		panelBotoes.add(botaoOk);
		
		pack();
	}

}
