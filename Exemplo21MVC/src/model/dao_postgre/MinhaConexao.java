package model.dao_postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MinhaConexao {
	
	private static String URL = "jdbc:postgresql:Faculdade";
	private static String USER = "postgres";
	private static String PASS = "123456";
	
	static Connection getConexao() throws SQLException {
		try{
			Connection c = DriverManager.getConnection(URL, USER, PASS);
			return c;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}
	}
	

}
