package it.contrader.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MatchDTO {

	private int id;
	private int idSport;
	private int idUser;
	private int rate;
	private String address;
	// private String matchtime;
	private LocalDateTime matchtime;

	public MatchDTO() {
	}

	public MatchDTO(int id, int idSport, int idUser, int rate, String address, LocalDateTime matchtime) {
		this.idSport = idSport;
		this.idUser = idUser;
		this.rate = rate;
		this.address = address;
		this.matchtime = matchtime;
		this.id = id;

	}

	public MatchDTO(int idSport, int idUser, int rate, String address, LocalDateTime matchtime) {
		this.idSport = idSport;
		this.idUser = idUser;
		this.rate = rate;
		this.address = address;
		this.matchtime = matchtime;

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

	public LocalDateTime getMatchtime() {
		return matchtime;
	}

	public void setMatchtime(LocalDateTime matchtime) {
		this.matchtime = matchtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "\t" + idSport + "\t\t" + idUser + "\t\t" + rate + "\t\t" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(matchtime )+ "\t\t" + address;
	}

}