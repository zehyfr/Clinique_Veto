package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.PersonnelDAOImpl;

public interface PersonnelDAOFactory {

	public static PersonnelDAO getPersonnelDAO() {
		PersonnelDAO res = new PersonnelDAOImpl();
		return res;
	}
}
