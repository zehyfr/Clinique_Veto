package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.veto.DAL.ConnexionDAO;
import fr.eni.veto.DAL.DALException;


public class ConnexionDAOJdbcImpl extends JdbcTools implements ConnexionDAO {

	public String authentification(int id, String pass) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String role = "nul";
		
		try {
			connec = getConnection();
			stmt = connec.prepareStatement("select Role from Personnels WHERE CodePers = ?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			role = rs.getString("Role");
			
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
