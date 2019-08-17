import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Janela extends JFrame {
	
	JPasswordField passField;
	
	public Janela() {
		setTitle("Janela com JTextFields");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		
		passField = new JPasswordField(10);
		passField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] pass = passField.getPassword();
				String s = "senha";
				boolean passCorreto = true;
				for(int i=0; i<pass.length; i++) {
					if(pass[i] != s.charAt(i))
						passCorreto = false;
				}
				if(passCorreto)
					System.out.println("Password correto");
				else
					System.out.println("Pass Incorreto");
				
				for(int i=0; i<pass.length; i++) 
					pass[i] = '0';
			}
		});
		add(passField);
		
		
		pack();
		
	}
	
	
}
