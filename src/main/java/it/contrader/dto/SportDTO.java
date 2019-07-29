package it.contrader.dto;

public class SportDTO {
	
	private String name;
	
	private int id;
	
	private int players;

	
	public SportDTO() {
	}


	public SportDTO(String name, int players) {
		this.name = name;
		this.players = players;
	}



	public SportDTO(int id, String name, int players) {
		this.id = id;
		this.name = name;
		this.players = players;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPlayers() {
		return players;
	}


	public void setPlayers(int players) {
		this.players = players;
	}


	@Override
	public String toString() {
		return "SportDTO [name=" + name + ", id=" + id + ", players=" + players + "]";
	}	
	
	
}
