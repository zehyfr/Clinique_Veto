package fr.eni.veto.BO;

public class Animaux {
	
	private int CodeAnimal;
	private String NomAnimal;
	private String Sexe;
	private String Couleur;
	private String Race;
	private String Espece;
	private int CodeClient;
	private String Tatouage;
	private String Antecedant;
	private boolean Archive;
	
	public Animaux() {
		super();
	}
	
	public Animaux(String nomAnimal, String sexe, String couleur, String race, String espece,
			int codeClient, String tatouage, String antecedant, boolean archive) {
		super();
		NomAnimal = nomAnimal;
		Sexe = sexe;
		Couleur = couleur;
		Race = race;
		Espece = espece;
		CodeClient = codeClient;
		Tatouage = tatouage;
		Antecedant = antecedant;
		Archive = archive;
	}
	
	public Animaux(int codeAnimal, String nomAnimal, String sexe, String couleur, String race, String espece,
			int codeClient, String tatouage, String antecedant, boolean archive) {
		super();
		CodeAnimal = codeAnimal;
		NomAnimal = nomAnimal;
		Sexe = sexe;
		Couleur = couleur;
		Race = race;
		Espece = espece;
		CodeClient = codeClient;
		Tatouage = tatouage;
		Antecedant = antecedant;
		Archive = archive;
	}

	public int getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeAnimal(int codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	public String getNomAnimal() {
		return NomAnimal;
	}

	public void setNomAnimal(String nomAnimal) {
		NomAnimal = nomAnimal;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	public String getRace() {
		return Race;
	}

	public void setRace(String race) {
		Race = race;
	}

	public String getEspece() {
		return Espece;
	}

	public void setEspece(String espece) {
		Espece = espece;
	}

	public int getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(int codeClient) {
		CodeClient = codeClient;
	}

	public String getTatouage() {
		return Tatouage;
	}

	public void setTatouage(String tatouage) {
		Tatouage = tatouage;
	}

	public String getAntecedant() {
		return Antecedant;
	}

	public void setAntecedant(String antecedant) {
		Antecedant = antecedant;
	}

	public boolean isArchive() {
		return Archive;
	}

	public void setArchive(boolean archive) {
		Archive = archive;
	}

	@Override
	public String toString() {
		return "Animaux [CodeAnimal=" + CodeAnimal + ", NomAnimal=" + NomAnimal + ", Sexe=" + Sexe + ", Couleur="
				+ Couleur + ", Race=" + Race + ", Espece=" + Espece + ", CodeClient=" + CodeClient + ", Tatouage="
				+ Tatouage + ", Antecedant=" + Antecedant + ", Archive=" + Archive + "]";
	}
	
}
