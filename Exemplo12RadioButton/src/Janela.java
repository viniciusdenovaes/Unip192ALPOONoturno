import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Janela extends JFrame {
	
	JRadioButton[] tipoComida;
	JRadioButton[] tamanhoComida;
	
	public Janela() {
		setTitle("Janela com JTextFields");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(3, 2));
		
		tipoComida = new JRadioButton[3];
		tipoComida[0] = new JRadioButton("Vegano");
		tipoComida[1] = new JRadioButton("Vegetariano");
		tipoComida[2] = new JRadioButton("Onívoro");
		
		tamanhoComida = new JRadioButton[3];
		tamanhoComida[0] = new JRadioButton("Pequeno");
		tamanhoComida[1] = new JRadioButton("Médio");
		tamanhoComida[2] = new JRadioButton("Grande");
		
		ButtonGroup tipoGroup = new ButtonGroup();
		for(JRadioButton button : tipoComida) {
			tipoGroup.add(button);
		}
		ButtonGroup tamanhoGroup = new ButtonGroup();
		for(JRadioButton button : tamanhoComida) {
			tamanhoGroup.add(button);
		}
		
		
		for(int i=0; i<tipoComida.length; i++) {
			add(tipoComida[i]);
			add(tamanhoComida[i]);
		}
		
		
		pack();
		
	}
	
//	class ComportamentoCheckBoxes implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			for(JCheckBox check : checkBoxes)
//				if(check.isSelected())
//					System.out.println(
//							"Coloca " + check.getText());
//			System.out.println();
//		}
//		
//	}
	
	
	
	
}
