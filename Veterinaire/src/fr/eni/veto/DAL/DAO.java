package fr.eni.veto.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	protected static Connection getConnection() throws DALException {
		Connection connection;
		// Chargement du pilote JDBC
		// M�thode recommand�e par Oracle
		//DriverManager.registerDriver(new SQLServerDriver());
		
		// m�thode classique avec moins de d�pendance � SQLServer
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DALException("La Driver JDBC n'est pas trouvable");
		}

		// Obtenir une connexion
		String url = "jdbc:sqlserver://localhost:1433;databaseName=veto";
		try {
			connection = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Connection impossible");
		}
		return connection;
	}
	
	protected static void closeConnection(Connection con) throws DALException {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DALException("Fermeture de connection impossible");
			}
		}
	}
	
	
}