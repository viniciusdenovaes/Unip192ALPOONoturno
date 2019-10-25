package model.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Aluno;
import model.Cadastro;
import model.Curso;
import model.dao.Dao;

public class DaoPostgres implements Dao {

	@Override
	public List<Cadastro> buscarAlunoByNome(String nome) {
		
		List<Cadastro> cadastros = new ArrayList<>();
		Map<String, Cadastro> cadastrosMap = new HashMap<String, Cadastro>();
		
		try(Connection c = MinhaConexao.getConexao()){	
			String query = "SELECT a.ra, a.nome, ac.nome_curso "
					+ "FROM alunos a "
					+ "LEFT JOIN alunos_cursos ac "
					+ "ON (ac.ra=a.ra) "
					+ "WHERE LOWER(nome) LIKE LOWER(?)";
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%"+nome+"%");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Aluno aluno = new Aluno(rs.getString("ra"), rs.getString("nome"));
				if(!cadastrosMap.containsKey(aluno.getRa())) {
					cadastrosMap.put(aluno.getRa(), new Cadastro(aluno));
				}
				System.out.println(rs.getString("nome_curso"));
				if(rs.getString("nome_curso") != null) {
					Curso curso = new Curso(rs.getString("nome_curso"));
					cadastrosMap.get(aluno.getRa()).addCurso(curso);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		for(Cadastro c : cadastrosMap.values())
			cadastros.add(c);
		return cadastros;
	}

	
	public List<Cadastro> buscarAlunoByNome_v2(String nome) {
		
		List<Cadastro> cadastros = new ArrayList<>();
		Map<String, Cadastro> cadastrosMap = new HashMap<String, Cadastro>();
		
		try(
				Connection c = MinhaConexao.getConexao()
				){
			
			
			String query = "SELECT * FROM alunos "
					+ "WHERE LOWER(nome) LIKE LOWER(?)";
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%"+nome+"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno(rs.getString("ra"), 
						                rs.getString("nome"));
				cadastrosMap.put(aluno.getRa(), new Cadastro(aluno));
			}
			
			
			query = "SELECT a.ra, a.nome, ac.nome_curso "
					+ "FROM alunos_cursos ac "
					+ "INNER JOIN alunos a "
					+ "ON (ac.ra=a.ra) "
					+ "WHERE LOWER(nome) LIKE LOWER(?)";
			pstm = c.prepareStatement(query);
			pstm.setString(1, "%"+nome+"%");
			rs = pstm.executeQuery();
			while(rs.next()) {
				Curso curso = new Curso(rs.getString("nome_curso"));
				cadastrosMap.get(rs.getString("ra")).addCurso(curso);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		for(Cadastro c : cadastrosMap.values())
			cadastros.add(c);
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
				System.out.println(curso);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	@Override
	public boolean addAluno(Aluno aluno) {
		boolean resultado = true;
		System.out.println("aidcionando " + aluno);
		try(
				Connection c = MinhaConexao.getConexao()
				){
			String query = "INSERT INTO alunos "
					+ "VALUES(?, ?)";
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, aluno.getRa());
			pstm.setString(2, aluno.getNome());
			resultado = pstm.executeUpdate()>0 ? true : false;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean addCurso(Curso curso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCursoInAluno(Aluno aluno, Curso curso) {
		boolean resultado = true;
		try(
				Connection c = MinhaConexao.getConexao()
				){
			String query = "INSERT INTO alunos_cursos "
					+ "VALUES(?, ?)";
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, curso.getNome());
			pstm.setString(2, aluno.getRa());
			resultado = pstm.executeUpdate()>0 ? true : false;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
