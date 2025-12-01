package jdbcDemo.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Fetch {

	public static void main(String[] args) {
		String url1= "jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
		//String user1 = "postgres";
	//String password1 = "123";
			try {
				// Step 1 Load and register driver software
				Class.forName("org.postgresql.Driver");
				System.out.println("driver loaded!!!");

				// Step 2 Establishing connection to DB
				Connection con = DriverManager.getConnection(url1);
				System.out.println("connection established to school DB");
				DatabaseMetaData data=con.getMetaData();
				System.out.println(data.getDriverName());
				System.out.println(data.getDriverVersion());
				System.out.println(data.getDatabaseProductName());
				System.out.println(data.getDatabaseProductVersion());
				
			//	String sql="INSERT into student values(?,?,?)";
			//  String sql="DELETE from student where id=?";
			//  String sql="UPDATE student set age=? where id=?";
				String sql="SELECT * from student where age>=?";
			//	String sql="SELECT * from student where age>=?";
				//Step 3 creating statement
				PreparedStatement pstm=con.prepareStatement(sql);
//				pstm.setInt(1, 1001);
//				pstm.setString(2, "girish");
//                pstm.setInt(3, 21);
				pstm.setInt(1, 21);
                int res=pstm.executeUpdate();
                if(res!=0) {
                	System.out.println("data is saved");
                }
                System.out.println(res);
			//	ResultSet rs=pstm.executeQuery();
			//	pstm.executeBatch();
//				boolean flag=pstm.execute();
//				System.out.println(flag);
				//pstm.executeUpdate();
				
				
//			while(rs.next()) {
//					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
//				}
//				
//				ResultSetMetaData metaData=rs.getMetaData();
//				System.out.println(metaData.getColumnName(1));
//				System.out.println(metaData.getColumnTypeName(1));
//				System.out.println(metaData.getColumnCount());
//				
	}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

}
}
