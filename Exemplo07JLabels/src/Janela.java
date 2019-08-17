import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends JFrame {
	
	public Janela() {
		setTitle("Janela com JLabels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		
		JLabel meuLabel = new JLabel("JLabel!!");
		add(meuLabel);
		
		add(new JLabel("JLabel Anonimo"));
		
		
		
		pack();
		
	}
		
		
	
}
