package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

public class DAOPostgres {
	
	static String URL = "jdbc:postgresql:Faculdade";
	static String USER = "postgres";
	static String PASS = "123456";
	
	public List<Aluno> buscaAlunos(String nome) {
		
		List<Aluno> alunos = new ArrayList<>();
		
		try(Connection c = 
				DriverManager.getConnection(URL, USER, PASS)){
			String query = 
					"SELECT * FROM alunos "
					+ "WHERE LOWER(nome) LIKE LOWER(?)";
			
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%"+nome+"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Aluno aluno = 
						new Aluno(
								rs.getString("ra"), 
								rs.getString("nome"));
				alunos.add(aluno);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		return alunos;
		
	
	}
	
	public boolean addAluno(String ra, String nome) {
		
		int row = 0;
		
		try(Connection c = 
				DriverManager.getConnection(URL, USER, PASS)){
			String update = 
					"INSERT INTO alunos VALUES(?, ?)";
			
			PreparedStatement pstm = c.prepareStatement(update);
			pstm.setString(1, ra);
			pstm.setString(2, nome);
			row = pstm.executeUpdate();
		}catch(PSQLException e) {
			System.out.println("nao adicionado");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(row==0)
			return false;
		else 
			return true;
	}
}
