package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.veto.DAL.ConnexionDAO;
import fr.eni.veto.DAL.DALException;


public class ConnexionDAOJdbcImpl extends JdbcTools implements ConnexionDAO {

	public String authentification(int id, String pass) throws DALException{
		Connection connec = null;
		Statement stmt = null;
		String role = "nul";
		
		try {
			connec = getConnection();
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery("select Role from Personnels");
			while(rs.next()) {
				role = rs.getString("Role");
			}
		}catch (SQLException e) {
			throw new DALException("Erreur connexion");
		}finally {
			try{
				closeAll(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
		return role;
	}
}
