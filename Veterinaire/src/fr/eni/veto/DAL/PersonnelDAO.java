package fr.eni.veto.DAL;

import java.util.ArrayList;

import fr.eni.veto.BO.Personnels;

public interface PersonnelDAO {

	public ArrayList<Personnels> getListPersonnels() throws DALException;
	public void modification(String aNom, String aRole, int aCodePers) throws DALException;
	public void archivage(int aCodePers) throws DALException;
	public void create(String aNom, String aRole) throws DALException;
	public String getAsalarie(int aCode) throws DALException;
}
