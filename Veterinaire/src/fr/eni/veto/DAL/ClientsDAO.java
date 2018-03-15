package fr.eni.veto.DAL;

import java.util.ArrayList;

import fr.eni.veto.BO.Clients;

public interface ClientsDAO {

	public void createClient(Clients c) throws DALException;
	public void updateClient(Clients c) throws DALException;
	public ArrayList<Clients> selectAllClients() throws DALException;
	public Clients selectClients(int code) throws DALException;
	public void deleteClients(int aCodeClient) throws DALException;
}
