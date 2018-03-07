package fr.eni.veto.DAL;

public interface ConnexionDAO {
	public String authentification(int id, String pass) throws DALException;
}
