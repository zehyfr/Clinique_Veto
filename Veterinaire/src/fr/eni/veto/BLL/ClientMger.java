package fr.eni.veto.BLL;

import java.util.ArrayList;

import fr.eni.veto.BO.Clients;
import fr.eni.veto.DAL.ClientsDAO;
import fr.eni.veto.DAL.ClientsDAOFactory;
import fr.eni.veto.DAL.DALException;

public class ClientMger {

	
	
	public ArrayList<Clients> getAllClients() //throws BLLException
	{
		ClientsDAO getListClients = ClientsDAOFactory.getClientsDAO();
		ArrayList<Clients> res = new ArrayList<Clients>();
		
		try {
			res = getListClients.selectAllClients();
		} catch (DALException e) {
			//throw new BLLException(e.getMessage() + "Erreur lors de la récuperation de la liste de tout les clients");
			e.printStackTrace();
		}
		return res;
	}

	public Clients getAclients(int aCode) throws DALException 
	{
		ClientsDAO getClients = ClientsDAOFactory.getClientsDAO();
		return getClients.selectClients(aCode);
	} 
}
