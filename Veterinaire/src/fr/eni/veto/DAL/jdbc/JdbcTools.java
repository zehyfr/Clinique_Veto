package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.veto.DAL.Settings;

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
		System.out.println("urldb="+urldb+";userdb="+userdb+";passworddb="+passworddb);
	}
	
	public static Connection getConnection() throws SQLException{
		Connection c = DriverManager.getConnection(urldb, userdb, passworddb);
		return c;
	}
	
	public static void closeAll(Connection c, Statement s) throws SQLException{
		if(s != null) {
			s.close();
		}
		if(c != null) {
		c.close();
		}
	}
}

