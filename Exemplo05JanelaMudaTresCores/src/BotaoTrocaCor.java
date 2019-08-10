import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotaoTrocaCor extends JButton{
	
	Color color;
	String nome;
	JPanel panel;
	
	public BotaoTrocaCor(
			Color aColor, 
			String aNome, 
			JPanel aPanel) {
		super(aNome);
		
		this.color = aColor;
		this.nome = aNome;
		this.panel = aPanel;
		
		addActionListener(new ComportamentoMudaCor());
		
	}
	
	class ComportamentoMudaCor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			panel.setBackground(color);
		}
		
	}

}
