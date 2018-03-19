package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.EspecesDAOImpl;

public class EspecesDAOFactory {

	public static EspecesDAO getAgendaDAO() {
		EspecesDAO res = new EspecesDAOImpl();
		return res;
	}
}
