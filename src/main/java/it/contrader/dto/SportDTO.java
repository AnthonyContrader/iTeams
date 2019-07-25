package it.contrader.dto;


public class SportDTO {

	private int id;
	private int players;	
	private String name;
	
	
	
	public SportDTO () {}
	
	public SportDTO (int id,int players, String name) {
		this.players= players;		
		this.name= name;
		this.id= id;
						
	}

	public SportDTO (int players, String name) {
		this.players= players;		
		this.name= name;
		
	
	}

	public int getPlayers() {
		return players;
	}
	
	public void setPlayers(int players) {
		this.players= players;
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

	@Override
	public String toString() {
		return "SportDTO [players= " + players + ", name= " + name + ", id= " + id + "]";
	}
	
}
