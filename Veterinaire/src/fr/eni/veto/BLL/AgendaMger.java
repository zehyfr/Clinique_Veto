package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Agendas;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.agenda.AgendaDAOImpl;

public class AgendaMger {
	
	public void nouveauRDV(Agendas agendas) throws DALException
	{
		AgendaDAOImpl insertAnimal = new AgendaDAOImpl();
		insertAnimal.ajouterRdv(agendas);
	}
	
	public ArrayList<Agendas> getRDV() throws DALException
	{
		AgendaDAOImpl getList = new AgendaDAOImpl();
		return getList.selectAll();
	}
}
