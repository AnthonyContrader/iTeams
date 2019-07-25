package it.contrader.model;

public class Sport {

	private int id;
	
	private int players;	
	
	private String name;
		
	

	public Sport(int id, int players, String name) {
		super();
		this.id = id;
		this.players = players;		
		this.name = name;
		
	}

	public Sport(int players, String name) {
		super();
		this.players = players;		
		this.name = name;
	}

	public Sport() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", players=" + players + ", name=" + name + "]";
	}	
	
}

