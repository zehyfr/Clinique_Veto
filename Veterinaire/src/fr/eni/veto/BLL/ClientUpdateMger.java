package fr.eni.veto.BLL;

import fr.eni.veto.DAL.ClientsDAO;
import fr.eni.veto.DAL.ClientsDAOFactory;
import fr.eni.veto.DAL.DALException;

public class ClientUpdateMger {
	
	public void archive(int aCodePers)
	{
		ClientsDAO archivage = ClientsDAOFactory.getClientsDAO();
		
		try {
			archivage.deleteClients(aCodePers);
		} catch (DALException e) {
		}
	}

}
