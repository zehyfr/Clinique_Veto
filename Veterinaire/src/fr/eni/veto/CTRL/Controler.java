package fr.eni.veto.CTRL;

import fr.eni.veto.BLL.LoginMger;

public class Controler {
	
	private boolean res = false;
	
	public boolean validation(String login, String mdp)
	{
		LoginMger log = new LoginMger();
		int loginInt = Integer.parseInt(login);
		
		if(log.connection(loginInt, mdp).equals("VET") || log.connection(loginInt, mdp).equals("ADM") || log.connection(loginInt, mdp).equals("SEC"))
		{
			res = true;
		}
	
		return res;
		
	}

}
