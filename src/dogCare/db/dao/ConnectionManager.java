package dogCare.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection singletonConnection;
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	
	private ConnectionManager() {
	
	}
	
	static {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			singletonConnection = DriverManager.getConnection(url, "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return singletonConnection;
	}
	
	
}
