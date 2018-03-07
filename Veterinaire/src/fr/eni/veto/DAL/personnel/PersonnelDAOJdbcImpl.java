package fr.eni.veto.DAL.personnel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.veto.BO.Personnels;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.DAO;

public class PersonnelDAOJdbcImpl extends DAO{
	
	public ArrayList<Personnels> getListPersonnels() throws DALException{
		Connection connec = super.getConnection();
		Statement stmt = null;
		ArrayList<Personnels> listPers = new ArrayList<Personnels>();
		
		try {
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery("select CodePers, Nom, Role from Personnels WHERE Archive = 0");
			while(rs.next())
			{
				Personnels pers= new Personnels(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("Role"));
				listPers.add(pers);
			}
		}catch (SQLException e) {
			throw new DALException("Erreur connexion");
		}finally {
			try{
				if(stmt != null) {
					stmt.close();
				}
				closeConnection(connec);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
		return listPers;
	}
	
	public void modification(String aNom, String aRole, int aCodePers) throws DALException{
		Connection connec = super.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = connec.prepareStatement("UPDATE Personnels SET Nom = ?, Role = ? WHERE CodePers = ?");
			stmt.setString(1, aNom);
			stmt.setString(2, aRole);
			stmt.setInt(3, aCodePers);
			stmt.execute();

		}catch (SQLException e) {
			throw new DALException("Erreur connexion");
		}finally {
			try{
				if(stmt != null) {
					stmt.close();
				}
				closeConnection(connec);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
	}
	
	public void archivage(int aCodePers) throws DALException{
		Connection connec = super.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = connec.prepareStatement("UPDATE Personnels SET Archive = 1 WHERE CodePers = ?");
			stmt.setInt(1, aCodePers);
			stmt.execute();

		}catch (SQLException e) {
			throw new DALException("Erreur connexion");
		}finally {
			try{
				if(stmt != null) {
					stmt.close();
				}
				closeConnection(connec);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
	}
}
