package fr.eni.veto.BLL;

import fr.eni.veto.BO.Clients;
import fr.eni.veto.DAL.ClientsDAO;
import fr.eni.veto.DAL.ClientsDAOFactory;
import fr.eni.veto.DAL.DALException;

public class ClientAjoutMger {
	public void ajoutClient(Clients c)
	{
		ClientsDAO createAdd = ClientsDAOFactory.getClientsDAO();
		
		try {
			 createAdd.createClient(c);
			 
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
}
