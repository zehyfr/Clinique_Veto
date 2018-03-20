package fr.eni.veto.DAL;

import java.util.ArrayList;

import fr.eni.veto.BO.Especes;

public interface EspecesDAO {

	public ArrayList<Especes> selectAllEspeces() throws DALException;
	public void ajouter(String espece, String race) throws DALException;
	
}
