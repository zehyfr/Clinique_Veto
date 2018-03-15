package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.ClientsDAOImpl;

public class ClientsDAOFactory {
	
	public static ClientsDAO getClientsDAO() {
		ClientsDAO res = new ClientsDAOImpl();
		return res;
	}
}
