package fr.eni.veto.DAL;

import fr.eni.veto.DAL.Client.ClientsDAOImpl;

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
