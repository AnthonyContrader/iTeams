package it.contrader.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SportDTO {
	
	private int id;
	private String name;
	private int players;

	
	public SportDTO( String name, int players) {
		super();
		this.name = name;
		this.players = players;
		
	}
}
