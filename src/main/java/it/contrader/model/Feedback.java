package it.contrader.model;

import java.util.Date;

public class Feedback {

	private int id;
	
	private int idSport;
	
	private int idUser;
	
	private int rate;
	
	
	

	public Feedback(int id, int idSport, int idUser, int rate) {
		super();
		this.id = id;
		this.idSport = idSport;
		this.idUser = idUser;
		this.rate = rate;

	}

	public Feedback(int idSport, int idUser, int rate) {
		super();
		this.idSport = idSport;
		this.idUser = idUser;
		this.rate = rate;

	}

	public Feedback() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSport() {
		return idSport;
	}

	public void setIdSport(int idSport) {
		this.idSport = idSport;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		return "Match [id=" + id + ", idSport=" + idSport + ", idUser=" + idUser + ", rate=" + rate  + "]";
	}

	
	
	
}
