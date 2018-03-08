package fr.eni.veto.BLL;

import fr.eni.veto.BO.Clients;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.Client.ClientsDAOImpl;

public class ClientAjoutMger {
	public void ajoutClient(Clients c)
	{
		ClientsDAOImpl createAdd = new ClientsDAOImpl();
		
		try {
			 createAdd.createClient(c);
			 
		} catch (DALException e) {
			
		}
	}
}
