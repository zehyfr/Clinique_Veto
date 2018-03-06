package fr.eni.veto.BO;

public class Races {
	
	private String Race;
	private String Espece;
	
	public Races()
	{
	}

	public Races(String race, String espece) {
		super();
		Race = race;
		Espece = espece;
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

	@Override
	public String toString() {
		return "Races [Race=" + Race + ", Espece=" + Espece + "]";
	}
	
}
