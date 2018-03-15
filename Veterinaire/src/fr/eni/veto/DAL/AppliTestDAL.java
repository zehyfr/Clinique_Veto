package fr.eni.veto.DAL;

import java.util.Date;

import fr.eni.veto.BO.Agendas;
import fr.eni.veto.DAL.jdbc.AgendaDAOImpl;

public class AppliTestDAL {
	
	public static void main(String[] args) {
		AgendaDAOImpl dao = new AgendaDAOImpl();
		Agendas a = new Agendas(8, new Date(System.currentTimeMillis()), 6);
		try {
		dao.ajouterRdv(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("DONE");
	}
}
