package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import fr.eni.veto.BO.Agendas;
import fr.eni.veto.DAL.AgendaDAO;
import fr.eni.veto.DAL.DALException;

public class AgendaDAOImpl implements AgendaDAO{
	private JdbcTools jdbc;

	public void ajouterRdv(Agendas a) throws DALException {
		Connection connec = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Agendas (CodeVeto, DateRdv, CodeAnimal, NomVeto, NomClient) values (?,?,?,?,?);";
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement(sql);
			stmt.setInt(1, a.getCodeVeto());
			stmt.setTimestamp(2, new Timestamp(a.getDateRdv().getTime()));
			stmt.setInt(3, a.getCodeAnimal());
			stmt.setString(4, a.getNomVeto());
			stmt.setString(5, a.getNomClient());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Insert Agendas impossible.");
		} finally {
			try {
				closeCoAndStatement(connec, stmt);
			} catch (SQLException ec) {
				throw new DALException(ec.getMessage() + "Fermeture connexion Agendas insert.");
			}
		}
	}

	public ArrayList<Agendas> selectAll(int aVeto, Date aDate) throws DALException {
		Date aDateTommorow = aDate;
		Calendar c = Calendar.getInstance(); 
		c.setTime(aDateTommorow); 
		c.add(Calendar.DATE, 1);
		aDateTommorow = c.getTime();
		
		Connection connec = null;
		Statement stmt = null;
		ArrayList<Agendas> res = new ArrayList<Agendas>();
		String stamp = "SMALLDATETIMEFROMPARTS(" + new SimpleDateFormat("yyyy").format(aDate) +","+ new SimpleDateFormat("MM").format(aDate)+ ","+new SimpleDateFormat("dd").format(aDate)+ "," + new SimpleDateFormat("HH").format(00)+ "," + new SimpleDateFormat("mm").format(00)+")";
		String stampBis = "SMALLDATETIMEFROMPARTS(" + new SimpleDateFormat("yyyy").format(aDateTommorow) +","+ new SimpleDateFormat("MM").format(aDateTommorow)+ ","+new SimpleDateFormat("dd").format(aDateTommorow)+ "," + new SimpleDateFormat("HH").format(00)+ "," + new SimpleDateFormat("mm").format(00)+")";
		String sql = "SELECT CodeVeto, DateRdv, CodeAnimal, NomVeto, NomClient FROM Agendas WHERE CodeVeto = " + aVeto+ " AND DateRdv >= " + stamp + " AND DateRdv < " + stampBis +" ORDER BY DateRdv;";
		try {
			connec = jdbc.getConnection();
			stmt = connec.createStatement();
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				res.add(new Agendas(rs.getInt("CodeVeto"), rs.getTimestamp("DateRdv"), rs.getInt("CodeAnimal"),
						rs.getString("NomVeto"), rs.getString("NomClient")));
			}
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Select Agendas impossible.");
		} finally {
			try {
				closeCoAndStatement(connec, stmt);
			} catch (SQLException ec) {
				throw new DALException(ec.getMessage() + "Fermeture connexion Agendas select.");
			}
		}
		return res;
	}

	public void supprimerRdv(Agendas a) throws DALException {
		Connection connec = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM Agendas where CodeVeto = ? and DateRdv = ? and CodeAnimal = ?;";
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement(sql);
			stmt.setInt(1, a.getCodeVeto());
			stmt.setTimestamp(2, new Timestamp(a.getDateRdv().getTime()));
			stmt.setInt(3, a.getCodeAnimal());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Suppression Agendas impossible.");
		} finally {
			try {
				closeCoAndStatement(connec, stmt);
			} catch (SQLException ec) {
				throw new DALException(ec.getMessage() + "Fermeture connexion Agendas suppression.");
			}
		}
	}
	
	/**
	 * Selectionner un client
	 * @param code
	 * @return
	 * @throws DALException
	 * @throws SQLException 
	 */
	
	public int verify(int aCode, Date aDate) throws DALException{
		Connection connec = null;
		Statement stmt = null;
		int res = 0;
		String stamp = "SMALLDATETIMEFROMPARTS(" + new SimpleDateFormat("yyyy").format(aDate) +","+ new SimpleDateFormat("MM").format(aDate)+ ","+new SimpleDateFormat("dd").format(aDate)+ "," + new SimpleDateFormat("HH").format(aDate)+ "," + new SimpleDateFormat("mm").format(aDate);
		String requete = "SELECT CodeVeto FROM Agendas WHERE CodeVeto = " + aCode +" and DateRdv = " + stamp + ");";
		try {
			connec = jdbc.getConnection();
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			
			if(rs.next())
			{
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Verification agenda impossible.");
		} finally {
			try {
				closeCoAndStatement(connec, stmt);
			} catch (SQLException ec) {
				throw new DALException(ec.getMessage() + "Fermeture connexion Agendas suppression.");
			}
		}
			return res;
	}
	
	
	public void closeCoAndStatement(Connection connec, Statement stmt) throws SQLException{
		if(stmt != null) {
			stmt.close();
		}
		jdbc.closeConnection(connec);
	}
}
