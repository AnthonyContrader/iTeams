package it.contrader.dto;

import java.util.Set;

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
	private Set<EventDTO> eventsDTO;
	private Set<UserDTO> likesDTO;
	private Set<FeedbackDTO> sportfeedDTO;
	
}
