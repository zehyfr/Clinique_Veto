package fr.eni.veto.DAL.agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.veto.BO.Agendas;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.jdbc.JdbcTools;

public class AgendaDAOImpl extends JdbcTools{

	public void ajouterRdv(Agendas a) throws DALException{
		Connection connec = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Agendas (CodeVeto, DateRdv, CodeAnimal) values (?,?,?);";
		try {
			connec = getConnection();
			stmt = connec.prepareStatement(sql);
			stmt.setInt(1, a.getCodeVeto());
			stmt.setTimestamp(2, new Timestamp(a.getDateRdv().getTime()));
			stmt.setInt(3,  a.getCodeAnimal());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Insert Agendas impossible.");
		} finally {
			try {
				closeAll(connec, stmt);
			} catch (SQLException ec) {
				throw new DALException(ec.getMessage() + "Fermeture connexion Agendas insert.");
			}
		}
	}
	
	public List<Agendas> selectAll() throws DALException{
		Connection connec = null;
		Statement stmt = null;
		List<Agendas> res = new ArrayList<Agendas>();
		String sql = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas;";
		try {
			connec = getConnection();
			stmt = connec.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res.add(new Agendas(rs.getInt("CodeVeto"), rs.getDate("DateRdv"), rs.getInt("CodeAnimal")));
			}
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Select Agendas impossible.");
		} finally {
			try {
				closeAll(connec, stmt);
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
			connec = getConnection();
			stmt = connec.prepareStatement(sql);
			stmt.setInt(1, a.getCodeVeto());
			stmt.setTimestamp(2, new Timestamp(a.getDateRdv().getTime()));
			stmt.setInt(3, a.getCodeAnimal());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage() + "Suppression Agendas impossible.");
		} finally {
			try {
				closeAll(connec, stmt);
			} catch (SQLException ec) {
				throw new DALException(ec.getMessage() + "Fermeture connexion Agendas suppression.");	
			}
		}
	}
}
