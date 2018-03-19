package fr.eni.veto.DAL;

import java.util.ArrayList;

import fr.eni.veto.BO.Especes;

public interface EspecesDAO {

	public ArrayList<String> selectAllEspeces() throws DALException;
	public ArrayList<String> selectRaces(String pEspece) throws DALException;
	public void ajouter(Especes pEspece) throws DALException;
	public void supprimerEspece(String pEspece) throws DALException;
	public void supprimerRace(Especes pEspece) throws DALException;
	
}
