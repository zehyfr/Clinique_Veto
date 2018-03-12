package fr.eni.veto.BO;

import java.util.Date;

public class Agendas {
	
	private int CodeVeto;
	private Date DateRdv;
	private int CodeAnimal;
	
	public Agendas()
	{
	}

	public Agendas(int codeVeto, Date dateRdv, int codeAnimal) {
		super();
		CodeVeto = codeVeto;
		DateRdv = dateRdv;
		CodeAnimal = codeAnimal;
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

	@Override
	public String toString() {
		return "Agendas [CodeVeto=" + CodeVeto + ", DateRdv=" + DateRdv + ", CodeAnimal=" + CodeAnimal + "]";
	}
	
}
