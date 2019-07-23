package it.contrader.model;

import java.sql.Date;

public class Match {

	private int id;
	
	private int idSport;
	
	private int idUser;
	
	private int rate;
	
	private String address;
	
	private Date matchtime;
	
	

	public Match(int id, int idSport, int idUser, int rate, String address, Date matchtime) {
		super();
		this.id = id;
		this.idSport = idSport;
		this.idUser = idUser;
		this.rate = rate;
		this.matchtime = matchtime;
		this.address = address;
	}

	public Match(int idSport, int idUser, int rate, String address, Date matchtime) {
		super();
		this.idSport = idSport;
		this.idUser = idUser;
		this.rate = rate;
		this.matchtime = matchtime;
		this.address = address;
	}

	public Match() {
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

	public Date getMatchtime() {
		return matchtime;
	}

	public void setMatchtime(Date matchtime) {
		this.matchtime = matchtime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", idSport=" + idSport + ", idUser=" + idUser + ", rate=" + rate + ", matchtime="
				+ matchtime + ", address=" + address + "]";
	}

	
	
	
}
