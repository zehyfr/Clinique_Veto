package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
	private static  String urldb;
	private static String userdb;
	private static String passworddb;
	
	static {
		
		try {
			Class.forName(Settings.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
	}
	
	public Connection getConnection() throws SQLException{
		Connection c = DriverManager.getConnection(urldb, userdb, passworddb);
		return c;
	}
	
	public void closeConnection(Connection c) throws SQLException{
		if(c != null) {
		c.close();
		}
	}
}

