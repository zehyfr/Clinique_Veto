package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.veto.DAL.ConnexionDAO;
import fr.eni.veto.DAL.DALException;


public class ConnexionDAOImpl implements ConnexionDAO {
	
	private JdbcTools jdbc;

	public String authentification(int id, String pass) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String role = "nul";
		
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement("select Role from Personnels WHERE CodePers = ?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			role = rs.getString("Role");
			
		}catch (SQLException e) {
			throw new DALException("Erreur connexion");
		}finally {
			try{
				closeCoAndStatement(connec, stmt);
			}catch(SQLException ex) {
				throw new DALException(ex.getMessage() + "Erreur fermeture connexion");
			}
		}
		return role;
	}
	
	public void closeCoAndStatement(Connection connec, Statement stmt) throws SQLException{
		if(stmt != null) {
			stmt.close();
		}
		jdbc.closeConnection(connec);
	}
}
