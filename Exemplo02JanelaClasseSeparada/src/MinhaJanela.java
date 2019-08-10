import javax.swing.JFrame;

public class MinhaJanela extends JFrame{
	
	public MinhaJanela(String tituloDaJanela) {
		super(tituloDaJanela);
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
