package it.contrader.dto;

import java.util.Date;

public class MatchCountDTO {
	
	private int subscribers;
	private int idMatch;
	private Date matchtime;
	private String address;
	private int max;
	
	public MatchCountDTO() {
	}

	public MatchCountDTO(int subscribers, int idMatch, Date matchtime, String address, int max) {
		this.subscribers = subscribers;
		this.idMatch = idMatch;
		this.matchtime = matchtime;
		this.address = address;
		this.max = max;
	}

	public int getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(int subscribers) {
		this.subscribers = subscribers;
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
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

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "MatchCountDTO [subscribers=" + subscribers + ", idMatch=" + idMatch + ", matchtime=" + matchtime
				+ ", address=" + address + ", max=" + max + "]";
	}
	
}
