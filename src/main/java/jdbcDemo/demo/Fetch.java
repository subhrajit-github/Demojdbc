package jdbcDemo.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Fetch {

	public static void main(String[] args) {
		String url1= "jdbc:postgresql://localhost:5432/school";
		String user1 = "postgres";
		String password1 = "123";
			try {
				// Step 1 Load and register driver software
				Class.forName("org.postgresql.Driver");
				System.out.println("driver loaded!!!");

				// Step 2 Establishing connection to DB
				Connection con = DriverManager.getConnection(url1, user1, password1);
				System.out.println("connection established to school DB");
				DatabaseMetaData data=con.getMetaData();
				System.out.println(data.getDriverName());
				System.out.println(data.getDriverVersion());
				System.out.println(data.getDatabaseProductName());
				System.out.println(data.getDatabaseProductVersion());
				
				
				String sql="SELECT * from student where age>=?";
				//Step 3 creating statement
				PreparedStatement pstm=con.prepareStatement(sql);
				pstm.setInt(1, 23);
				ResultSet rs=pstm.executeQuery();
				
				
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				}
				
				ResultSetMetaData metaData=rs.getMetaData();
				System.out.println(metaData.getColumnName(1));
				System.out.println(metaData.getColumnTypeName(1));
				System.out.println(metaData.getColumnCount());
				
	}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

}
}
