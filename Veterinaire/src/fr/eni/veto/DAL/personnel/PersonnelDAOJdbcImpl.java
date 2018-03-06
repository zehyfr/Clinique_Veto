package fr.eni.veto.DAL.personnel;

import java.sql.Connection;
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
			ResultSet rs = stmt.executeQuery("select CodePers, Nom, Role from Personnels");
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
	
	public void modification() throws DALException{
		Connection connec = super.getConnection();
		Statement stmt = null;
		
		try {
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE Personnels SET Nom = ?, Role = ? WHERE CodePers = ?");

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
