package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pool {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/ORGANIZER";
	
	static final String USER = "root";
	static final String PASSWORD = "password";
	
	public static Connection createDBConection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			return conn;
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
