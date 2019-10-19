package model.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Cadastro;
import model.Curso;
import model.dao.Dao;

public class DaoPostgres implements Dao {

	@Override
	public List<Cadastro> buscarAlunoByNome(String nome) {
		List<Cadastro> cadastros = new ArrayList<>();
		try(
				Connection c = MinhaConexao.getConexao()
				){
			
			String query = "SELECT a.ra, a.nome, ac.nome_curso "
					+ "FROM alunos_cursos ac "
					+ "INNER JOIN alunos a "
					+ "ON (ac.ra=a.ra) "
					+ "WHERE LOWER(nome) LIKE LOWER(?)";
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%"+nome+"%");
			ResultSet rs = pstm.executeQuery();
			Cadastro cadastroAnterior = null;
			while(rs.next()) {
				Aluno aluno = new Aluno(rs.getString("ra"), 
						                rs.getString("nome"));
				Cadastro cadastro = new Cadastro(aluno);
				if(
						cadastroAnterior!=null &&
						cadastro.getAluno().getRa().equals(
						cadastroAnterior.getAluno().getRa())) {
					cadastro = cadastroAnterior;
				}
				else if(cadastroAnterior!=null) {
					cadastros.add(cadastroAnterior);
				}
				Curso curso = new Curso(rs.getString("nome_curso"));
				cadastro.addCurso(curso);
				cadastroAnterior = cadastro;
			}
			cadastros.add(cadastroAnterior);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return cadastros;
	}

	@Override
	public List<Curso> buscarCursosByNome(String nome) {
		
		List<Curso> cursos = new ArrayList<>();
		try(
				Connection c = MinhaConexao.getConexao()
				){
			String query = "SELECT * FROM cursos "
					+ "WHERE LOWER(nome) LIKE LOWER(?)";
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%"+nome+"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Curso curso = new Curso(rs.getString("nome"));
				cursos.add(curso);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	@Override
	public boolean addAluno(Aluno aluno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCurso(Curso curso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCursoInAluno(Aluno aluno, Curso curso) {
		// TODO Auto-generated method stub
		return false;
	}

}
