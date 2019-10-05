import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JanelaTabbed extends JFrame {
	
	JButton botao01 = new JButton("painel 01");
	JButton botao02 = new JButton("painel 02");
	JButton botao03 = new JButton("painel 03");
	JButton botaoProximo = new JButton("Proximo");
	JButton botaoAnterior = new JButton("Anterior");
	JButton botaoPrimeiro = new JButton("Primeiro");
	JButton botaoUltimo = new JButton("Ultimo");
	
	CardLayout cl = new CardLayout();
	JPanel painelCard = new JPanel(cl);
	
	public JanelaTabbed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		String painelAzul = "painel azul";
		painelCard.add( 
				new PainelCor(Color.BLUE, "Painel um"), 
				painelAzul);
		painelCard.add( 
				new PainelCor(Color.PINK, "Painel dois"), 
				"painel rosa");
		painelCard.add( 
				new PainelCor(Color.GREEN, "Painel tres"), 
				"painel verde");
		painelCard.add( 
				new PainelCor(Color.RED, "Painel quatro"), 
				"painel vermelho");
		
		botao01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(painelCard, painelAzul);
			}
		});
		botao02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(painelCard, "painel rosa");
			}
		});
		botao03.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(painelCard, "painel verde");
			}
		});
		botaoAnterior.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.previous(painelCard);
			}
		});
		botaoProximo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.next(painelCard);
			}
		});
		botaoPrimeiro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.first(painelCard);
			}
		});
		botaoUltimo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.last(painelCard);
			}
		});
		
		setLayout(new BorderLayout());
		add(painelCard, BorderLayout.CENTER);
		
		JPanel botaoPanel = new JPanel();
		botaoPanel.add(botao01);
		botaoPanel.add(botao02);
		botaoPanel.add(botao03);
		botaoPanel.add(botaoAnterior);
		botaoPanel.add(botaoProximo);
		botaoPanel.add(botaoPrimeiro);
		botaoPanel.add(botaoUltimo);
		
		add(botaoPanel, BorderLayout.PAGE_END);
		
		pack();
		
	}
	
}
