import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TesteJanela {
	
	public static void main(String[] args) {
		
		JFrame janela = new JFrame();
		
		/*O codigo abaixo serve para definir o tamanho 
		 * da janela em relacao a tela do computador*/
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension tamanhoDaTela = kit.getScreenSize();
		
		double tamanhoRelativoLargura = 0.8;
		double tamanhoRelativoAltura  = 0.4;
		
		double larguraDaTela = 
				tamanhoRelativoLargura * 
				tamanhoDaTela.getWidth();
		double alturaDaTela =
				tamanhoRelativoAltura * 
				tamanhoDaTela.getHeight();
		/*O codigo para definir o tamanho relativo 
		 * da tela termina aqui*/
		janela.setSize(
				(int)larguraDaTela, (int)alturaDaTela);
		
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setVisible(true);
		
	}

}
