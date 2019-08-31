import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	
	static String URL = "jdbc:postgresql:Faculdade";
	static String USER = "postgres";
	static String PASS = "123456";
	
	public static void addAluno() {
		try(Connection c = 
				DriverManager.getConnection(URL, USER, PASS)){
			
			Statement stm = c.createStatement();
			stm.executeUpdate("INSERT INTO alunos VALUES ('125', 'ana')");
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void addAluno(String ra, String nome) {
		try(Connection c = 
				DriverManager.getConnection(URL, USER, PASS)){
			
			String query = 
					"INSERT INTO alunos VALUES (?, ?)";
			
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, ra);
			pstm.setString(2, nome);
			int rows = pstm.executeUpdate();
			System.out.println("linhas modificadas: " + rows);
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void mostrarAlunos() {
		try(Connection c = 
				DriverManager.getConnection(URL, USER, PASS)){
			
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(
					"SELECT * FROM alunos");
			while(rs.next()) {
				System.out.println(
						" ra: " + rs.getString(1) + 
						" nome: " + rs.getString("nome"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void mostrarAlunos(String nome) {
		try(Connection c = 
				DriverManager.getConnection(URL, USER, PASS)){
			String query = 
					"SELECT * FROM alunos "
					+ "WHERE LOWER(nome) LIKE LOWER(?)";
			
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%"+nome+"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				System.out.println(
						" ra: " + rs.getString(1) + 
						" nome: " + rs.getString("nome"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
	

}
