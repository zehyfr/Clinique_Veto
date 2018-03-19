package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.veto.BO.Animaux;
import fr.eni.veto.DAL.AnimauxDAO;
import fr.eni.veto.DAL.DALException;

public class AnimauxDAOImpl implements AnimauxDAO{
	
	private JdbcTools jdbc;
	
	public ArrayList<Animaux> selectByCodeClient(int code) throws DALException{
		Connection connec = null;
		Statement stmt = null;
		ArrayList<Animaux> res= new ArrayList<Animaux>();
		String sql = "Select CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, Tatouage, Antecedents, Archive FROM Animaux where CodeClient = " + code + " ;";
		try {
			connec = jdbc.getConnection();
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res.add(new Animaux(rs.getInt("CodeAnimal"), rs.getString("NomAnimal"), rs.getString("Sexe"), rs.getString("Couleur"), rs.getString("Race"), rs.getString("Espece"), code, rs.getString("Tatouage"), rs.getString("Antecedents"), rs.getBoolean("Archive")));
			}
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Select par code client impossible");
		} finally {
			try {
				closeCoAndStatement(connec, stmt);
			} catch(SQLException e) {
				throw new DALException(e.getMessage() + "Erreur fermeture connexion select par code client");
			}
		}
		return res;
	}
	
	public void insertAnimal(Animaux a) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Animaux (NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive) values (?,?,?,?,?,?,?,?,?);";
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, a.getNomAnimal());
			stmt.setString(2, a.getSexe());
			stmt.setString(3, a.getCouleur());
			stmt.setString(4, a.getRace());
			stmt.setString(5, a.getEspece());
			stmt.setInt(6, a.getCodeClient());
			stmt.setString(7, a.getTatouage());
			stmt.setString(8, a.getAntecedant());
			stmt.setBoolean(9, a.isArchive());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			a.setCodeAnimal(rs.getInt(1));
		}catch (SQLException e) {
			throw new DALException(e.getMessage() + "Insert animal impossible");
		} finally {
			try {
				closeCoAndStatement(connec, stmt);
			} catch (SQLException e) {
				throw new DALException(e.getMessage() + "Erreur fermeture connexion Insert animal");
			}
		}
	}
	
	public void updateAnimal(Animaux a) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE Animaux set NomAnimal = ?, Sexe = ?, Couleur = ?, Race = ?, Espece = ?, CodeClient = ?, Tatouage = ?, Antecedents = ?, Archive = ? where CodeAnimal = ?;";
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement(sql);
			stmt.setString(1, a.getNomAnimal());
			stmt.setString(2, a.getSexe());
			stmt.setString(3, a.getCouleur());
			stmt.setString(4, a.getRace());
			stmt.setString(5, a.getEspece());
			stmt.setInt(6, a.getCodeClient());
			stmt.setString(7, a.getTatouage());
			stmt.setString(8, a.getAntecedant());
			stmt.setBoolean(9, a.isArchive());
			stmt.setInt(10, a.getCodeAnimal());
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new DALException(e.getMessage() + "Update animal impossible");
		} finally {
			try {
				closeCoAndStatement(connec, stmt);
			} catch (SQLException e) {
				throw new DALException(e.getMessage() + "Erreur fermeture connexion Update animal");
			}
		}
	}
	
	public void deleteAnimal(int code) throws DALException{
		Connection connec = null;
		Statement stmt = null;
		String sql = "UPDATE Animaux set Archive = true where CodeAnimal = " + code + ";";
		try {
			connec = jdbc.getConnection();
			stmt = connec.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Impossible de delete animal");
		} finally {
			try {
				closeCoAndStatement(connec, stmt);
			} catch (SQLException e) {
				throw new DALException(e.getMessage() + "Erreur fermeture connexion delete animal");
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
