package fr.eni.veto.dal;

import fr.eni.veto.dal.jdbc.ConnexionDAOJdbcImpl;

public class ConnexionFactory {

	public static ConnexionDAO getConnexionDAO() {
		ConnexionDAO co = new ConnexionDAOJdbcImpl();
		return co;
	}
}
