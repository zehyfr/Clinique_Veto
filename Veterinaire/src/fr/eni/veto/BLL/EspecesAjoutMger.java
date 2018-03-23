package fr.eni.veto.BLL;

import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.EspecesDAO;
import fr.eni.veto.DAL.EspecesDAOFactory;

public class EspecesAjoutMger {
	
	public void ajouter(String anEspece, String aRace)
	{
		EspecesDAO ajouter = EspecesDAOFactory.getEspeceDAO();
		
		try {
			ajouter.ajouter(anEspece, aRace);
			 
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
