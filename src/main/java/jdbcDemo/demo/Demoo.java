package jdbcDemo.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demoo {
 
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String password="123";
	public static void main(String[] args) {
		try {
			//Step 1 load and register driver software
			Class.forName("org.postgresql.Driver");
			System.out.println("driver loaded!!!");	
			
			//Step 2 establishing connection to DB
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("connection established to school DB");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
