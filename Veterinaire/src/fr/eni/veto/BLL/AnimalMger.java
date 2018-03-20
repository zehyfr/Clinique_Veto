package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Animaux;
import fr.eni.veto.BO.Especes;
import fr.eni.veto.DAL.AnimauxDAO;
import fr.eni.veto.DAL.AnimauxDAOFactory;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.EspecesDAO;
import fr.eni.veto.DAL.EspecesDAOFactory;

public class AnimalMger {

ArrayList<Animaux> res = new ArrayList<Animaux>();
	
	public ArrayList<Animaux> getAllAnimaux(int aClient)
	{
		AnimauxDAO getListAnimaux = AnimauxDAOFactory.getAnimauxDAO();
		
		try {
			 res = getListAnimaux.selectByCodeClient(aClient);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public void insertAnimal(Animaux animal) throws DALException
	{
		AnimauxDAO insertAnimal = AnimauxDAOFactory.getAnimauxDAO();
		insertAnimal.insertAnimal(animal);
	}
	
	public void updateAnimal(Animaux animal) throws DALException
	{
		AnimauxDAO insertAnimal = AnimauxDAOFactory.getAnimauxDAO();
		insertAnimal.updateAnimal(animal);
	}
	
	ArrayList<Especes> res2 = new ArrayList<Especes>();
	
	public ArrayList<Especes> getEspece()
	{
		EspecesDAO getEspece = EspecesDAOFactory.getEspeceDAO();
		
		try {
			 res2 = getEspece.selectAllEspeces();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return res2;
	}

}