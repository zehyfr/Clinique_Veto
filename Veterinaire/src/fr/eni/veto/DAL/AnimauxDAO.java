package fr.eni.veto.DAL;

import java.util.ArrayList;

import fr.eni.veto.BO.Animaux;

public interface AnimauxDAO {

	public ArrayList<Animaux> selectByCodeClient(int code) throws DALException;
	public void insertAnimal(Animaux a) throws DALException;
	public void updateAnimal(Animaux a) throws DALException;
	public void deleteAnimal(int code) throws DALException;
}
