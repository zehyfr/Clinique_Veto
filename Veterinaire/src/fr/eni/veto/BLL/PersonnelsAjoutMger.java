package fr.eni.veto.BLL;

import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.personnel.PersonnelDAOJdbcImpl;

public class PersonnelsAjoutMger {
	
	public void create(String aNom, String aRole)
	{
		PersonnelDAOJdbcImpl createAdd = new PersonnelDAOJdbcImpl();
		
		try {
			 createAdd.create(aNom, aRole);
			 
		} catch (DALException e) {
			
		}
	}
}
