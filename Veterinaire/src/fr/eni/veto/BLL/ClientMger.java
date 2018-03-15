package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Clients;
import fr.eni.veto.DAL.ClientsDAO;
import fr.eni.veto.DAL.ClientsDAOFactory;
import fr.eni.veto.DAL.DALException;

public class ClientMger {
	
ArrayList<Clients> res = new ArrayList<Clients>();
	
	public ArrayList<Clients> getAllClients() //throws BLLException
	{
		ClientsDAO getListClients = ClientsDAOFactory.getClientsDAO();
		
		try {
			 res = getListClients.selectAllClients();
		} catch (DALException e) {
			//throw new BLLException(e.getMessage() + "Erreur lors de la récuperation de la liste de tout les clients");
		}
		return res;
	}

}
