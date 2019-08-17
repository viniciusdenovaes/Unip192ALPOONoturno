import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Janela extends JFrame {
	
	JTextArea textArea;
	
	public Janela() {
		setTitle("Janela com JTextFields");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		
		textArea = new JTextArea(5, 20);
		add(textArea);
		
		
		pack();
		
	}
	
	
}
