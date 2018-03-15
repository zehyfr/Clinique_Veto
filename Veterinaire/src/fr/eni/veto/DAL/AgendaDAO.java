package fr.eni.veto.DAL;

import java.util.ArrayList;
import java.util.Date;

import fr.eni.veto.BO.Agendas;

public interface AgendaDAO {

	public void ajouterRdv(Agendas a) throws DALException;
	public ArrayList<Agendas> selectAll(int aVeto, Date aDate) throws DALException;
	public void supprimerRdv(Agendas a) throws DALException;
	public int verify(int aCode, Date aDate) throws DALException;
	
}
