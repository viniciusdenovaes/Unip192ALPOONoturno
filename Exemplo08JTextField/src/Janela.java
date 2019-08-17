import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela extends JFrame {
	
	JTextField textField;
	JLabel label;
	
	public Janela() {
		setTitle("Janela com JTextFields");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(2, 1));
		
		textField = new JTextField(20);
		textField.addActionListener(new ComportamentoTextField());
		add(textField);
		
		label = new JLabel(" ");
		add(label);
		
		
		pack();
		
	}
	
	class ComportamentoTextField implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String texto = textField.getText();
			textField.setText("");
			label.setText(texto);
		}
	}
	
}
