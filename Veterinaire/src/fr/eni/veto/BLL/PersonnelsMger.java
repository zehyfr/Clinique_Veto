package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Personnels;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.personnel.PersonnelDAOJdbcImpl;

public class PersonnelsMger {
	
	ArrayList<Personnels> res = new ArrayList<Personnels>();
	
	public ArrayList<Personnels> getPersonnels()
	{
		PersonnelDAOJdbcImpl getListPersonnels = new PersonnelDAOJdbcImpl();
		
		try {
			 res = getListPersonnels.getListPersonnels();
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
