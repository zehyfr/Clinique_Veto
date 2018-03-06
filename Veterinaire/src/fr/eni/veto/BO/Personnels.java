package fr.eni.veto.BO;

public class Personnels {
	
	private int CodePers;
	private String Nom;
	private String MotPasse;
	private String Role;
	private boolean Archive;
	
	public Personnels()
	{
	}

	public Personnels(int codePers, String nom, String motPasse, String role, boolean archive) {
		super();
		CodePers = codePers;
		Nom = nom;
		MotPasse = motPasse;
		Role = role;
		Archive = archive;
	}
	
	public Personnels(int codePers, String nom, String role) {
		super();
		CodePers = codePers;
		Nom = nom;
		Role = role;
	}

	public int getCodePers() {
		return CodePers;
	}

	public void setCodePers(int codePers) {
		CodePers = codePers;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getMotPasse() {
		return MotPasse;
	}

	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public boolean isArchive() {
		return Archive;
	}

	public void setArchive(boolean archive) {
		Archive = archive;
	}

	@Override
	public String toString() {
		return CodePers + " - " + Nom;

	}
}
