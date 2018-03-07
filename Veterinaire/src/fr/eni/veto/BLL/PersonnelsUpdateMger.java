package fr.eni.veto.BLL;

import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.personnel.PersonnelDAOJdbcImpl;

public class PersonnelsUpdateMger {
	
	public void update(String aNom, String aRole, int aCodePers)
	{
		PersonnelDAOJdbcImpl personnelsUp = new PersonnelDAOJdbcImpl();
		
		try {
			 personnelsUp.modification(aNom, aRole, aCodePers);
		} catch (DALException e) {
		}
	}
	
	public void archive(int aCodePers)
	{
		PersonnelDAOJdbcImpl personnelsUp = new PersonnelDAOJdbcImpl();
		
		try {
			 personnelsUp.archivage(aCodePers);
		} catch (DALException e) {
		}
	}

}
