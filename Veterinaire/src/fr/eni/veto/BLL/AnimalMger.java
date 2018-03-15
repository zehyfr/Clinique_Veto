package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Animaux;
import fr.eni.veto.DAL.AnimauxDAO;
import fr.eni.veto.DAL.AnimauxDAOFactory;
import fr.eni.veto.DAL.DALException;

public class AnimalMger {

ArrayList<Animaux> res = new ArrayList<Animaux>();
	
	public ArrayList<Animaux> getAllAnimaux(int aClient)
	{
		AnimauxDAO getListAnimaux = AnimauxDAOFactory.getAnimauxDAO();
		
		try {
			 res = getListAnimaux.selectByCodeClient(aClient);
		} catch (DALException e) {
		}
		
		return res;
	}
	
	public void insertAnimal(Animaux animal) throws DALException
	{
		AnimauxDAO insertAnimal = AnimauxDAOFactory.getAnimauxDAO();
		insertAnimal.insertAnimal(animal);
	}

}