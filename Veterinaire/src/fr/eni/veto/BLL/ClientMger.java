package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Clients;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.Client.ClientsDAOImpl;

public class ClientMger {
	
ArrayList<Clients> res = new ArrayList<Clients>();
	
	public ArrayList<Clients> getAllClients()
	{
		ClientsDAOImpl getListClients = new ClientsDAOImpl();
		
		try {
			 res = getListClients.selectAllClients();
		} catch (DALException e) {
		}
		
		return res;
	}

}
