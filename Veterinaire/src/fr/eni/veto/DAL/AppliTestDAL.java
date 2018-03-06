package fr.eni.veto.DAL;

import fr.eni.veto.DAL.jdbc.ConnexionDAOJdbcImpl;

public class AppliTestDAL {
	
	public static void main(String[] args) {
		
		ConnexionDAOJdbcImpl coDAO = new ConnexionDAOJdbcImpl();
		String res = "NOPE";
		try {
			res = coDAO.authentification(1, "22TEST22");
		}catch(DALException d) {
			System.out.println(d.getMessage());
		}
		System.out.println(res);
	}
}
