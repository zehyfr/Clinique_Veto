package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.AgendaDAOImpl;

public class AgendaDAOFactory {

	public static AgendaDAO getAgendaDAO() {
		AgendaDAO res = new AgendaDAOImpl();
		return res;
	}
}
