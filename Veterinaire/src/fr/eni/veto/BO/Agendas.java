package fr.eni.veto.BO;

import java.util.Date;

public class Agendas {
	
	private int CodeVeto;
	private Date DateRdv;
	private int CodeAnimal;
	
	private String nomVeto;
	private String nomClient;
	
	public Agendas()
	{
	}

	public Agendas(int codeVeto, Date dateRdv, int codeAnimal, String nomVeto, String nomClient) {
		super();
		CodeVeto = codeVeto;
		DateRdv = dateRdv;
		CodeAnimal = codeAnimal;
		this.nomVeto = nomVeto;
		this.nomClient = nomClient;
	}

	public int getCodeVeto() {
		return CodeVeto;
	}

	public void setCodeVeto(int codeVeto) {
		CodeVeto = codeVeto;
	}

	public Date getDateRdv() {
		return DateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		DateRdv = dateRdv;
	}

	public int getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeAnimal(int codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	public String getNomVeto() {
		return nomVeto;
	}

	public void setNomVeto(String nomVeto) {
		this.nomVeto = nomVeto;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	@Override
	public String toString() {
		return getDateRdv() + " pour " + getCodeAnimal();
	}
}
