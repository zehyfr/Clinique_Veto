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

	public String authentification(int anId, String aPass) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String role = "nul";
		String pass = " ";
		if(aPass!=null)
		{
			pass=aPass;
		}
		
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement("select Role from Personnels WHERE CodePers = ? AND MotPasse = ?");
			stmt.setInt(1, anId);
			stmt.setString(2,pass);

			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				role = rs.getString("Role");
			}
		}catch (SQLException e) {
			e.printStackTrace();
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
