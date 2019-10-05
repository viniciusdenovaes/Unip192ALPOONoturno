import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelCor extends JPanel {
	
	public PainelCor(Color cor, String texto) {
		//setSize(300, 300);
		setPreferredSize(new Dimension(300, 300));
		setBackground(cor);
		add(new JLabel(texto));
	}

}
