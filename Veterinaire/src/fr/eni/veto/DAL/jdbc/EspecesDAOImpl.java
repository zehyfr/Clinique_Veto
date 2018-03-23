package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.veto.BO.Especes;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.EspecesDAO;

public class EspecesDAOImpl implements EspecesDAO{

	private JdbcTools jdbc;
	@Override
	public ArrayList<Especes> selectAllEspeces() throws DALException {
		Connection connec = null;
		Statement stmt = null;
		int i = -1;
		String especePrec = "";
		String nomEspece = null;
		String sql = "SELECT Espece, Race FROM Races ORDER BY Espece;";
		ArrayList<Especes> res = new ArrayList<Especes>(); 
		try {
			connec = jdbc.getConnection();
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				nomEspece = rs.getString("Espece");
				if(nomEspece.equals(especePrec)) {
					res.get(i).addRace(rs.getString("Race"));
				}else {
					res.add(new Especes(nomEspece, rs.getString("Race")));
					especePrec = nomEspece;
					i++;
				}
			}
		}catch (SQLException e) {
			throw new DALException(e.getMessage() + " Probleme lors du select des especes.");
		}finally {
			try {
				closeCoAndStatement(connec, stmt);
			}catch (SQLException ex) {
				throw new DALException(ex.getMessage() + " Erreur fermeture Connexion.");
			}
		}
		return res;
	}

	@Override
	public void ajouter(String espece, String race) throws DALException {
		Connection connec = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Races (Espece, Race) values (?, ?);";
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement(sql);
			stmt.setString(1, espece);
			stmt.setString(2, race);
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new DALException(e.getMessage() + " Probleme lors de l insert d'une espece/race.");
		}finally {
			try {
				closeCoAndStatement(connec, stmt);
			}catch (SQLException ex) {
				throw new DALException(ex.getMessage() + " Erreur fermeture Connexion.");
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
