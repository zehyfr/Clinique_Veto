package fr.eni.veto.dal;

public interface ConnexionDAO {
	public String authentification(int id, String pass) throws DALException;
}
