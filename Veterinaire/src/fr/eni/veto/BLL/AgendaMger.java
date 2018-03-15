package fr.eni.veto.BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import fr.eni.veto.BO.Agendas;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.agenda.AgendaDAOImpl;

public class AgendaMger {
	
	public void nouveauRDV(Agendas agendas) throws DALException
	{
		AgendaDAOImpl insertAnimal = new AgendaDAOImpl();
		insertAnimal.ajouterRdv(agendas);
	}
	
	public ArrayList<Agendas> getRDV(int aVeto, Date aDate) throws DALException
	{
		AgendaDAOImpl getList = new AgendaDAOImpl();
		return getList.selectAll(aVeto, aDate);
	}
	
	public int verify(int aCode, Date aDate) throws DALException, SQLException
	{
		AgendaDAOImpl agendaVerif = new AgendaDAOImpl();
		return agendaVerif.verify(aCode, aDate);
	}
}
