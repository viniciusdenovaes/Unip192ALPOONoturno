package view;

import java.awt.event.ActionListener;
import java.util.List;

import model.Aluno;

public interface View {
	
	public void prepare();
	public void init();
	
	public void addComportamentoBusca(ActionListener al);
	public String getTextoBusca();
	public void exibirAlunos(List<Aluno> alunos);
	
	public void addComportamentoAdicionar(ActionListener al);
	public Aluno getAluno();
	public void exibeResultadoAdicionar(boolean resultado);
	

}
