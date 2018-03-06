package fr.eni.veto.dal.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.veto.BO.Clients;
import fr.eni.veto.dal.DALException;
import fr.eni.veto.dal.jdbc.JdbcTools;

public class ClientsDAOImpl {

	public void createClient(Clients c) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String requete = "INSERT INTO Clients (NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive) values(?,?,?,?,?,?,?,?,?,?,?);";
		try {
			connec = JdbcTools.getConnection();
			stmt = connec.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getNomClient());
			stmt.setString(2, c.getPrenomClient());
			stmt.setString(3, c.getAdresse1());
			stmt.setString(4, c.getAdresse2());
			stmt.setString(5, c.getCodePostal());
			stmt.setString(6, c.getVille());
			stmt.setString(7, c.getNumTel());
			stmt.setString(8, c.getAssurance());
			stmt.setString(9, c.getEmail());
			stmt.setString(10, c.getRemarque());
			stmt.setBoolean(11, c.isArchive());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			c.setCodeClient(rs.getInt(1));
		}catch (SQLException e) {
			throw new DALException("Insertion non effectuee");
		}finally {
			try{
				closeAll(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
	}
	
	public void updateClient(Clients c) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String requete = "UPDATE Clients set NomClient = ?, PrenomClient = ?, Adresse1 = ?, Adresse2 = ?, CodePostal = ?, Ville = ?, NumTel = ?, Assurance = ?, Email = ?, Remarque = ?, Archive = ? where CodeClient = ?;";
		try {
			connec = JdbcTools.getConnection();
			stmt = connec.prepareStatement(requete);
			stmt.setString(1, c.getNomClient());
			stmt.setString(2, c.getPrenomClient());
			stmt.setString(3, c.getAdresse1());
			stmt.setString(4, c.getAdresse2());
			stmt.setString(5, c.getCodePostal());
			stmt.setString(6, c.getVille());
			stmt.setString(7, c.getNumTel());
			stmt.setString(8, c.getAssurance());
			stmt.setString(9, c.getEmail());
			stmt.setString(10, c.getRemarque());
			stmt.setBoolean(11, c.isArchive());
			stmt.setInt(12, c.getCodeClient());
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new DALException(e.getMessage() + "Update non effectuee");
		}finally {
			try{
				closeAll(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
	}
	
	public List<Clients> selectAllClients() throws DALException{
		Connection connec = null;
		Statement stmt = null;
		String requete = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive FROM Clients;";
		List<Clients> all = new ArrayList<Clients>();
		try {
			connec = JdbcTools.getConnection();
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while(rs.next()) {
				all.add(new Clients(rs.getInt("CodeClient"), rs.getString("NomClient"), rs.getString("PrenomClient"), rs.getString("Adresse1"), rs.getString("Adresse2"), rs.getString("codePostal"), rs.getString("Ville"), rs.getString("NumTel"), rs.getString("Assurance"), rs.getString("Email"), rs.getString("Remarque"), rs.getBoolean("Archive")));
			}
		}catch (SQLException e) {
			throw new DALException("Select all non effectuee");
		}finally {
			try{
				closeAll(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
		return all;
	}
	
	public Clients selectClients(int code) throws DALException{
		Connection connec = null;
		Statement stmt = null;
		String requete = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive FROM Clients where CodeClient = " + code + ";";
		Clients result = null;
		try {
			connec = JdbcTools.getConnection();
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			rs.next();
			result = new Clients(rs.getInt("CodeClient"), rs.getString("NomClient"), rs.getString("PrenomClient"), rs.getString("Adresse1"), rs.getString("Adresse2"), rs.getString("codePostal"), rs.getString("Ville"), rs.getString("NumTel"), rs.getString("Assurance"), rs.getString("Email"), rs.getString("Remarque"), rs.getBoolean("Archive"));
			
		}catch (SQLException e) {
			throw new DALException("Delete non effectuee");
		}finally {
			try{
				closeAll(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
		return result;
	}
	
	public void deleteClients(int code) throws DALException{
		Connection connec = null;
		Statement stmt = null;
		String requete = "DELETE FROM Clients where CodeClient = " + code + ";";
		try {
			connec = JdbcTools.getConnection();
			stmt = connec.createStatement();
			stmt.executeUpdate(requete);
		}catch (SQLException e) {
			throw new DALException("Delete non effectuee");
		}finally {
			try{
				closeAll(connec, stmt);
			}catch(Exception ex) {
				throw new DALException("Erreur fermeture connexion");
			}
		}
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
