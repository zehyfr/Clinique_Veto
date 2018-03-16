package fr.eni.veto.BLL;

import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.PersonnelDAO;
import fr.eni.veto.DAL.PersonnelDAOFactory;

public class PersonnelsUpdateMger {
	
	public void update(String aNom, String aRole, int aCodePers)
	{
		PersonnelDAO personnelsUp = PersonnelDAOFactory.getPersonnelDAO();
		
		try {
			 personnelsUp.modification(aNom, aRole, aCodePers);
		} catch (DALException e) {
		}
	}
	
	public void archive(int aCodePers)
	{
		PersonnelDAO personnelsUp = PersonnelDAOFactory.getPersonnelDAO();
		
		try {
			 personnelsUp.archivage(aCodePers);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}
