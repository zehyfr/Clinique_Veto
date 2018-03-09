package fr.eni.veto.CTRL;

import java.util.ArrayList;

import fr.eni.veto.BLL.AnimalMger;
import fr.eni.veto.BLL.ClientAjoutMger;
import fr.eni.veto.BLL.ClientMger;
import fr.eni.veto.BLL.ClientUpdateMger;
import fr.eni.veto.BLL.LoginMger;
import fr.eni.veto.BLL.PersonnelsAjoutMger;
import fr.eni.veto.BLL.PersonnelsMger;
import fr.eni.veto.BLL.PersonnelsUpdateMger;
import fr.eni.veto.BO.Animaux;
import fr.eni.veto.BO.Clients;
import fr.eni.veto.BO.Personnels;
import fr.eni.veto.DAL.DALException;
import fr.eni.veto.IHM.Authentification;
import fr.eni.veto.IHM.MainView;

public class Controler {

	private String res = "";

	@SuppressWarnings("unused")
	private Authentification auth;
	@SuppressWarnings("unused")
	private MainView main;
	
	public Controler() {
		this.auth = new Authentification(this);
	}

	/**
	 * Connection personnel
	 * @param aNom, aRole, aCodePers
	 */
	public String validation(String login, String mdp) {
		LoginMger log = new LoginMger();
		int loginInt = Integer.parseInt(login);

		if (log.connection(loginInt, mdp).equals("VET") || log.connection(loginInt, mdp).equals("ADM")
				|| log.connection(loginInt, mdp).equals("SEC")) {
			res = log.connection(loginInt, mdp);
		}else{
			res = "0";
		}
		return res;
	}
	
	/**
	 * Modifier du personnel
	 * @param aNom, aRole, aCodePers
	 */
	public void update(String aNom, String aRole, int aCodePers){
		PersonnelsUpdateMger PUM = new PersonnelsUpdateMger();
		
		PUM.update(aNom, aRole, aCodePers);
	}
	
	/**
	 * Archiver du personnel
	 * @param aCodePers
	 */
	public void archive(int aCodePers){
		PersonnelsUpdateMger PUM = new PersonnelsUpdateMger();
		
		PUM.archive(aCodePers);
	}
	
	/**
	 * Contrôle d'accès
	 */
	public void acces(String aCode) {
		this.main = new MainView(this, aCode);
	}
	
	/**
	 * Récupérer la liste du personnel
	 */
	public ArrayList<Personnels> getListPersonnel()
	{
		PersonnelsMger list = new PersonnelsMger();
		return list.getPersonnels();
	}
	
	/**
	 * Créer du personnel
	 * @param aNom, aRole
	 */
	public void create(String aNom, String aRole)
	{
		PersonnelsAjoutMger createAdd = new PersonnelsAjoutMger();
		createAdd.create(aNom, aRole);
	}
	
	/**
	 * Récupérer la liste des clients
	 */
	
	public ArrayList<Clients> getAllClients()
	{
		ClientMger clientGetAll = new ClientMger();
		return clientGetAll.getAllClients();
	}
	
	/**
	 * Ajouter un client
	 * @param c
	 */
	public void ajouterClient(Clients c)
	{
		ClientAjoutMger createAdd = new ClientAjoutMger();
		createAdd.ajoutClient(c);
	}
	
	/**
	 * Archiver un client
	 */
	
	public void archivage(int aCodeClient)
	{
		ClientUpdateMger archive = new ClientUpdateMger();
		archive.archive(aCodeClient);
	}
	
	/**
	 * Recupère liste d'animaux d'un client
	 */
	
	public ArrayList<Animaux> getAllAnimaux(int aClient)
	{
		AnimalMger ani = new AnimalMger();
		return ani.getAllAnimaux(aClient);
	}
	
	/**
	 * Ajoute un nouvel animal
	 * @param animal
	 * @throws DALException
	 */
	public void insertAnimal(Animaux animal) throws DALException
	{
		AnimalMger insertAni = new AnimalMger();
		insertAni.insertAnimal(animal);
	}
	
}
