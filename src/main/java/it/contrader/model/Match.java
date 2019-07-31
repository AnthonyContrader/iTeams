package it.contrader.model;

import java.util.Date;

public class Match {
	
	private int id;
	private int idSport;
	private int idUser;
	private int rate;
	private String address;
	private Date matchtime;
	private boolean status;
	
	public Match() {

	}

	public Match(int idSport, int idUser, int rate, String address, Date matchtime, boolean status) {
		this.idSport = idSport;
		this.idUser = idUser;
		this.rate = rate;
		this.address = address;
		this.matchtime = matchtime;
		this.status = status;
	}

	public Match(int id, int idSport, int idUser, int rate, String address, Date matchtime, boolean status) {
		this.id = id;
		this.idSport = idSport;
		this.idUser = idUser;
		this.rate = rate;
		this.address = address;
		this.matchtime = matchtime;
		this.status = status;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getMatchtime() {
		return matchtime;
	}

	public void setMatchtime(Date matchtime) {
		this.matchtime = matchtime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", idSport=" + idSport + ", idUser=" + idUser + ", rate=" + rate + ", address="
				+ address + ", matchtime=" + matchtime + "]";
	}
	
	
		
	}
	

