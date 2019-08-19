package it.contrader.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	
	private int id;

	private String username;
	
	private String password;

	private String usertype;
	
	private Boolean status;
	
	private Set<EventDTO> createdEventsDTO;
	
	private Set<EventDTO> joinEventDTO;
	
	private Set<EventDTO> invitedEventDTO;
	
	private Set<TeamDTO> memberOfDTO;
	
	private Set<SportDTO> likeDTO;
	
	private Set<FeedbackDTO> givedDTO;
	
	private Set<FeedbackDTO> receivedDTO;
	
}
