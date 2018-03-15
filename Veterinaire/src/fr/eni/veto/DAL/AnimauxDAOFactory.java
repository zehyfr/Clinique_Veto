package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.AnimauxDAOImpl;

public class AnimauxDAOFactory {

	public static AnimauxDAO getAnimauxDAO() {
		AnimauxDAO res = new AnimauxDAOImpl();
		return res;
	}
}
