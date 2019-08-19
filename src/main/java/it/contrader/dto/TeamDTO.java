package it.contrader.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
	
	private int id;
	private String name;
//	private int idSport;
//	private int players;
	private EventDTO eventDTO;
	private Set<UserDTO> componentsDTO;
	
}