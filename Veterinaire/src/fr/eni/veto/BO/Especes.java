package fr.eni.veto.BO;

import java.util.ArrayList;

public class Especes {
	
	private String espece;
	private ArrayList<String> races;
	
	public Especes()
	{
	}

	public Especes(String race, String pEspece) {
		super();
		espece = pEspece;
		races = new ArrayList<String>();
		races.add(race);
	}

	public ArrayList<String> getRaces() {
		return races;
	}

	public void addRace(String pRace) {
		races.add(pRace);
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String pEspece) {
		espece = pEspece;
	}

	@Override
	public String toString() {
		return "Races [Races = " + races.toString() + ", Espece=" + espece + "]";
	}
	
}
