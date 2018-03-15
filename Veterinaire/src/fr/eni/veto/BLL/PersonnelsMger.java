package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Personnels;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.personnel.PersonnelDAOJdbcImpl;

public class PersonnelsMger {
	
	private ArrayList<Personnels> res = new ArrayList<Personnels>();
	private String result;
	
	public ArrayList<Personnels> getPersonnels()
	{
		PersonnelDAOJdbcImpl getListPersonnels = new PersonnelDAOJdbcImpl();
		
		try {
			 res = getListPersonnels.getListPersonnels();
		} catch (DALException e) {
		}
		
		return res;
	}
	
	public String getAsalarie(int aCode)
	{
		PersonnelDAOJdbcImpl getSalarie = new PersonnelDAOJdbcImpl();
		
		try {
			 result = getSalarie.getAsalarie(aCode);
		} catch (DALException e) {
		}
		return result;
	}

}
