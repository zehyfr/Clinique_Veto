package fr.eni.veto.BLL;

import fr.eni.veto.DAL.ConnexionDAO;
import fr.eni.veto.DAL.ConnexionDAOFactory;
import fr.eni.veto.DAL.DALException;

public class LoginMger {
	
	public String connection(int login , String mdp)
	{
		String res = "";
		ConnexionDAO co = ConnexionDAOFactory.getConnexionDAO();
		
		try {
			 res = co.authentification(login, mdp);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
