package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
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
		int i = 0;
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
	public void ajouter(Especes pEspece) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerEspece(String pEspece) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerRace(Especes pEspece) throws DALException {
		// TODO Auto-generated method stub
		
	}

	public void closeCoAndStatement(Connection connec, Statement stmt) throws SQLException{
		if(stmt != null) {
			stmt.close();
		}
		jdbc.closeConnection(connec);
	}
}
