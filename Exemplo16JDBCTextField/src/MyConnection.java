import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyConnection {
	
	static String URL = "jdbc:postgresql:Faculdade";
	static String USER = "postgres";
	static String PASS = "123456";
	
	static public ArrayList<Aluno> buscaAlunos(String nome) {
		
		ArrayList<Aluno> alunos = new ArrayList<>();
		
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

}
