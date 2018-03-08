package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Animaux;
import fr.eni.veto.DAL.AnimauxDAOImpl;
import fr.eni.veto.DAL.DALException;

public class AnimalMger {

ArrayList<Animaux> res = new ArrayList<Animaux>();
	
	public ArrayList<Animaux> getAllAnimaux(int aClient)
	{
		AnimauxDAOImpl getListAnimaux = new AnimauxDAOImpl();
		
		try {
			 res = getListAnimaux.selectByCodeClient(aClient);
		} catch (DALException e) {
		}
		
		return res;
	}

}