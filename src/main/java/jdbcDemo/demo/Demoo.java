package jdbcDemo.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demoo {
 
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String password="123";
	public static void main(String[] args) {
		try {
			//Step 1 Load and register driver software
			Class.forName("org.postgresql.Driver");
			System.out.println("driver loaded!!!");	
			
			//Step 2 Establishing connection to DB
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("connection established to school DB");
			
			//Step 3 Creating a statement
			Statement stm=con.createStatement();
			
			//String sql="Insert into student values(103,'Omm',23)";
			//String sql="DELETE from student where id=102";
			//String sql="UPDATE student set id=102 where id=103 ";
			String sql="SELECT * from student";
					
			
			
			//Step 4 Executing the query
			stm.execute(sql);
			System.out.println("data saved!");
			
			//Step 5 Closing the connection
			con.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
