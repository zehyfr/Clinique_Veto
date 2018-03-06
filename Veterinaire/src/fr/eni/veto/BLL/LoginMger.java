package fr.eni.veto.BLL;

import fr.eni.veto.DAL.DALException;
import fr.eni.veto.DAL.jdbc.ConnexionDAOJdbcImpl;

public class LoginMger {
	
	public String connection(int login , String mdp)
	{
		String res = "";
		ConnexionDAOJdbcImpl co = new ConnexionDAOJdbcImpl();
		
		try {
			 res = co.authentification(login, mdp);
		} catch (DALException e) {

		}
		
		return res;
	}

}
