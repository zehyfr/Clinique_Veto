package fr.eni.veto.BLL;

import java.util.ArrayList;
import java.util.Date;

import fr.eni.veto.BO.Agendas;
import fr.eni.veto.DAL.AgendaDAO;
import fr.eni.veto.DAL.AgendaDAOFactory;
import fr.eni.veto.DAL.DALException;

public class AgendaMger {
	
	public void nouveauRDV(Agendas agendas) throws DALException
	{
		AgendaDAO insertAnimal = AgendaDAOFactory.getAgendaDAO();
		insertAnimal.ajouterRdv(agendas);
	}
	
	public ArrayList<Agendas> getRDV(int aVeto, Date aDate) throws DALException
	{
		AgendaDAO getList = AgendaDAOFactory.getAgendaDAO();
		return getList.selectAll(aVeto, aDate);
	}
	
	public int verify(int aCode, Date aDate) throws DALException
	{
		AgendaDAO agendaVerif = AgendaDAOFactory.getAgendaDAO();
		return agendaVerif.verify(aCode, aDate);
	}
}
