package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.EspecesDAOImpl;

public class EspecesDAOFactory {

	public static EspecesDAO getEspeceDAO() {
		EspecesDAO res = new EspecesDAOImpl();
		return res;
	}
}
