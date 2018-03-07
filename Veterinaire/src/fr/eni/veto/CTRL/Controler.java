package fr.eni.veto.CTRL;

import java.util.ArrayList;

import fr.eni.veto.BLL.LoginMger;
import fr.eni.veto.BLL.PersonnelsMger;
import fr.eni.veto.BLL.PersonnelsUpdateMger;
import fr.eni.veto.BO.Personnels;
import fr.eni.veto.IHM.Authentification;
import fr.eni.veto.IHM.MainView;

public class Controler {

	private boolean res = false;

	@SuppressWarnings("unused")
	private Authentification auth;
	@SuppressWarnings("unused")
	private MainView main;
	
	public Controler() {
		this.auth = new Authentification(this);
	}

	public boolean validation(String login, String mdp) {
		LoginMger log = new LoginMger();
		int loginInt = Integer.parseInt(login);

		if (log.connection(loginInt, mdp).equals("VET") || log.connection(loginInt, mdp).equals("ADM")
				|| log.connection(loginInt, mdp).equals("SEC")) {
			res = true;
		}
		return res;
	}
	
	public void update(String aNom, String aRole, int aCodePers){
		PersonnelsUpdateMger PUM = new PersonnelsUpdateMger();
		
		PUM.update(aNom, aRole, aCodePers);
	}
	
	public void archive(int aCodePers){
		PersonnelsUpdateMger PUM = new PersonnelsUpdateMger();
		
		PUM.archive(aCodePers);
	}
	
	

	public void acces() {
		
		this.main = new MainView(this);
	}
	
	public ArrayList<Personnels> getListPersonnel()
	{
		PersonnelsMger list = new PersonnelsMger();
		return list.getPersonnels();
	}

}
