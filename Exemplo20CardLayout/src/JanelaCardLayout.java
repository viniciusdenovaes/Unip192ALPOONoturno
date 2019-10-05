import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaCardLayout extends JFrame {
	
	public JanelaCardLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		add(tabbedPane);
		
		tabbedPane.add(
				"primeiro painel", 
				new PainelCor(Color.BLUE, "Painel um"));
		tabbedPane.add(
				"segundo", 
				new PainelCor(Color.PINK, "Painel dois"));
		tabbedPane.add(
				"terceiro painel com nome muito grande", 
				new PainelCor(Color.GREEN, "Painel 3"));
		
		pack();
		
	}

}
