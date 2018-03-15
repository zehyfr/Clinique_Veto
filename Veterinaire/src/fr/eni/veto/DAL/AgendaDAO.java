package fr.eni.veto.DAL;

import java.util.ArrayList;

import fr.eni.veto.BO.Agendas;

public interface AgendaDAO {

	public void ajouterRdv(Agendas a) throws DALException;
	public ArrayList<Agendas> selectAll() throws DALException;
	public void supprimerRdv(Agendas a) throws DALException;
	
}
