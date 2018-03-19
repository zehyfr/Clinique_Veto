package fr.eni.veto.CTRL;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import fr.eni.veto.BLL.AgendaMger;
import fr.eni.veto.BLL.AnimalMger;
import fr.eni.veto.BLL.ClientAjoutMger;
import fr.eni.veto.BLL.ClientMger;
import fr.eni.veto.BLL.ClientUpdateMger;
import fr.eni.veto.BLL.LoginMger;
import fr.eni.veto.BLL.PersonnelsAjoutMger;
import fr.eni.veto.BLL.PersonnelsMger;
import fr.eni.veto.BLL.PersonnelsUpdateMger;
import fr.eni.veto.BO.Agendas;
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
	
	public Controler(){
		
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
			if("Nimbus".equals(info.getName())){
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		this.auth = new Authentification(this);
	}

	/**
	 * Connection à l'application via le code perso et son mot de passe
	 * @param aNom, aRole, aCodePers
	 */
	public String validation(String login, String mdp) {
		
		int loginInt = Integer.parseInt(login);

		LoginMger log = new LoginMger();
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
	public void acces(String aCode, int aCodePers) {
		this.main = new MainView(this, aCode, aCodePers);
		auth.getFrmIdentification().setVisible(false);
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
	
	/**
	 * Ajouter un rdv
	 * @param agendas
	 */
	public void rdv(Agendas agendas)
	{
		AgendaMger newRDV = new AgendaMger();
		try {
			newRDV.nouveauRDV(agendas);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Récuperer la liste des rdv
	 * @throws DALException 
	 */
	public ArrayList<Agendas> getRDV(int aVeto, Date aDate) throws DALException
	{
		AgendaMger rdv = new AgendaMger();
		return rdv.getRDV(aVeto, aDate);
	}
	
	/**
	 * Récuperer la liste des rdv
	 * @throws DALException 
	 */
	public Clients getClient(int aCode) throws DALException
	{
		ClientMger client = new ClientMger();
		return client.getAclients(aCode);
	}
	
	/**
	 * Vérifier la disponibilité d'un veto
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public Boolean verify(int aCode, Date aDate) throws DALException, SQLException, ParseException
	{
		AgendaMger agendaVerif = new AgendaMger();
		if(agendaVerif.verify(aCode, aDate)==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Récuperer un personnel
	 * @throws DALException 
	 */
	public String getSalarie(int aCode) throws DALException
	{
		PersonnelsMger personnels = new PersonnelsMger();
		return personnels.getAsalarie(aCode);
	}
	
	/**
	 * Changement du mot de passe 
	 * @throws DALException 
	 */
	public void modifMdp(int aCode, String aMdp) throws DALException
	{
		PersonnelsUpdateMger personnels = new PersonnelsUpdateMger();
		personnels.modifMotdepasse(aCode, aMdp);
	}
	
	public void getAuth(){
		auth.getFrmIdentification().setVisible(true);
	}
}
