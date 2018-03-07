package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.ConnexionDAOJdbcImpl;

public class ConnexionFactory {

	public static ConnexionDAO getConnexionDAO() {
		ConnexionDAO co = new ConnexionDAOJdbcImpl();
		return co;
	}
}
