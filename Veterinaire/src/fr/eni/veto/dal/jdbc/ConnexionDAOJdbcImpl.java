package fr.eni.veto.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.veto.dal.ConnexionDAO;
import fr.eni.veto.dal.DALException;


public class ConnexionDAOJdbcImpl implements ConnexionDAO{

	public String authentification(int id, String pass) throws DALException{
		Connection connec = null;
		Statement stmt = null;
		String role = "nul";
		
		try {
			connec = JdbcTools.getConnection();
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
	
	public void closeAll(Connection c, Statement s) throws SQLException{
		if(s != null) {
			s.close();
		}
		if(c != null) {
		c.close();
		}
	}
}
