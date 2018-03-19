package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Personnels;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.PersonnelDAO;
import fr.eni.veto.DAL.PersonnelDAOFactory;

public class PersonnelsMger {
	
	private ArrayList<Personnels> res = new ArrayList<Personnels>();
	private String result;
	
	public ArrayList<Personnels> getPersonnels(int from)
	{
		PersonnelDAO getListPersonnels = PersonnelDAOFactory.getPersonnelDAO();
		
		if(from == 0)
		{
			try {
				 res = getListPersonnels.getListPersonnels();
			} catch (DALException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				 res = getListPersonnels.getListPersonnelsVeterinaire();
			} catch (DALException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return res;
	}
	
	public String getAsalarie(int aCode)
	{
		PersonnelDAO getSalarie = PersonnelDAOFactory.getPersonnelDAO();
		
		try {
			 result = getSalarie.getAsalarie(aCode);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return result;
	} 

}
