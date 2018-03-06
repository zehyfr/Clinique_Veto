package fr.eni.veto.dal;

import fr.eni.veto.BO.Clients;
import fr.eni.veto.dal.Client.ClientsDAOImpl;

public class AppliTestDAL {
	
	public static void main(String[] args) {
		
		ClientsDAOImpl cliCo = new ClientsDAOImpl();
		try{
			System.out.println(cliCo.selectClients(1).toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
