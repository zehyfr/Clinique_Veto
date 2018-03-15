package fr.eni.veto.DAL.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import fr.eni.veto.BO.Agendas;
import fr.eni.veto.DAL.AgendaDAO;
import fr.eni.veto.DAL.DALException;

public class AgendaDAOImpl implements AgendaDAO{
	private JdbcTools jdbc;

	public void ajouterRdv(Agendas a) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Agendas (CodeVeto, DateRdv, CodeAnimal) values (?,?,?);";
		try {
			connec = jdbc.getConnection();
			stmt = connec.prepareStatement(sql);
			stmt.setInt(1, a.getCodeVeto());
			stmt.setTimestamp(2, new Timestamp(a.getDateRdv().getTime()));
			stmt.setInt(3,  a.getCodeAnimal());
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
	
	public ArrayList<Agendas> selectAll() throws DALException{
		Connection connec = null;
		Statement stmt = null;
		ArrayList<Agendas> res = new ArrayList<Agendas>();
		String sql = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas;";
		try {
			connec = jdbc.getConnection();
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res.add(new Agendas(rs.getInt("CodeVeto"), new Date(rs.getTimestamp("DateRdv").getTime()), rs.getInt("CodeAnimal")));
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
	
	public void supprimerRdv(Agendas a) throws DALException{
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
	
	public void closeCoAndStatement(Connection connec, Statement stmt) throws SQLException{
		if(stmt != null) {
			stmt.close();
		}
		jdbc.closeConnection(connec);
	}
}
