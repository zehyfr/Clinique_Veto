package fr.eni.veto.BLL;

import fr.eni.veto.dal.ConnexionDAO;
import fr.eni.veto.dal.ConnexionFactory;
import fr.eni.veto.dal.DALException;

public class LoginMger {
	
	public String connection(int login , String mdp)
	{
		String res = "";
		ConnexionDAO co = ConnexionFactory.getConnexionDAO();
		
		try {
			 res = co.authentification(login, mdp);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
