import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Janela extends JFrame {
	
	JCheckBox[] checkBoxes;
	
	public Janela() {
		setTitle("Janela com JTextFields");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		
		checkBoxes = new JCheckBox[3];
		checkBoxes[0] = new JCheckBox("Hamburger");
		checkBoxes[1] = new JCheckBox("Batata");
		checkBoxes[2] = new JCheckBox("Coca");
		
		
		for(JCheckBox check : checkBoxes) {
			check.addActionListener(
					new ComportamentoCheckBoxes());
			add(check);
		}
		
		
		
		
		
		pack();
		
	}
	
	class ComportamentoCheckBoxes implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for(JCheckBox check : checkBoxes)
				if(check.isSelected())
					System.out.println(
							"Coloca " + check.getText());
			System.out.println();
		}
		
	}
	
	
	
	
}
