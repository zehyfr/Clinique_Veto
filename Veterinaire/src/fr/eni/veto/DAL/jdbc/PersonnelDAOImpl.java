package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.veto.BO.Personnels;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.PersonnelDAO;

public class PersonnelDAOImpl implements PersonnelDAO{
	
	private JdbcTools jdbc;
	
	public ArrayList<Personnels> getListPersonnels() throws DALException{
		Connection connec = null;
		Statement stmt = null;
		ArrayList<Personnels> listPers = new ArrayList<Personnels>();
		
		try {
			connec = jdbc.getConnection();
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
				closeCoAndStatement(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
		return listPers;
	}
	
	public void modification(String aNom, String aRole, int aCodePers) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement("UPDATE Personnels SET Nom = ?, Role = ? WHERE CodePers = ?");
			stmt.setString(1, aNom);
			stmt.setString(2, aRole);
			stmt.setInt(3, aCodePers);
			stmt.execute();

		}catch (SQLException e) {
			throw new DALException("Erreur connexion");
		}finally {
			try{
				closeCoAndStatement(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
	}
	
	public void archivage(int aCodePers) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement("UPDATE Personnels SET Archive = 1 WHERE CodePers = ?");
			stmt.setInt(1, aCodePers);
			stmt.execute();

		}catch (SQLException e) {
			throw new DALException("Erreur connexion");
		}finally {
			try{
				closeCoAndStatement(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
	}
	
	public void create(String aNom, String aRole) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String requete = "INSERT INTO Personnels (Nom, MotPasse, Role, Archive) values(?,?,?,?)";
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aNom);
			stmt.setString(2, "123");
			stmt.setString(3, aRole);
			stmt.setBoolean(4, false);
			
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new DALException("Insertion non effectuee");
		}finally {
			try{
				closeCoAndStatement(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
	}
	
	public void closeCoAndStatement(Connection connec, Statement stmt) throws SQLException{
		if(stmt != null) {
			stmt.close();
		}
		jdbc.closeConnection(connec);
	}
}
