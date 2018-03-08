package fr.eni.veto.BLL;

import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.Client.ClientsDAOImpl;

public class ClientUpdateMger {
	
	public void archive(int aCodePers)
	{
		ClientsDAOImpl archivage = new ClientsDAOImpl();
		
		try {
			archivage.deleteClients(aCodePers);
		} catch (DALException e) {
		}
	}

}
