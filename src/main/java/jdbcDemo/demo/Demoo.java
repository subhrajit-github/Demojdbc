package jdbcDemo.demo;

public class Demoo {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("driver loaded!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
