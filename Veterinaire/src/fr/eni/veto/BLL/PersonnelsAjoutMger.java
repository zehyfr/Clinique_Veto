package fr.eni.veto.BLL;

import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.PersonnelDAO;
import fr.eni.veto.DAL.PersonnelDAOFactory;

public class PersonnelsAjoutMger {
	
	public void create(String aNom, String aRole)
	{
		PersonnelDAO createAdd = PersonnelDAOFactory.getPersonnelDAO();
		
		try {
			 createAdd.create(aNom, aRole);
			 
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
