package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.ConnexionDAOImpl;

public class ConnexionDAOFactory {

	public static ConnexionDAO getConnexionDAO() {
		ConnexionDAO co = new ConnexionDAOImpl();
		return co;
	}
}
