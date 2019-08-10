import javax.swing.JFrame;

public class TestaJanela {
	
	public static void main(String[] args) {
		
		MinhaJanela janela = new MinhaJanela();
		
	}
	
	static class MinhaJanela extends JFrame{
		public MinhaJanela() {
			setSize(600, 400);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}
	}

}
