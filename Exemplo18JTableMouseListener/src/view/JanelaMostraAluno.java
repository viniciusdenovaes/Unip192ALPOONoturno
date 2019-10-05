package view;

import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Aluno;

public class JanelaMostraAluno extends JFrame {
	
	public JanelaMostraAluno(Aluno aluno) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		add(new JLabel(aluno.ra));
		add(new JLabel(aluno.nome));
		
		pack();
	}

}
