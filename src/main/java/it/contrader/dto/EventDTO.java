package it.contrader.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

	private int id;
	//private String sportName;
	private UserDTO userDTO;
	private int rate;
	private String city;
	private String address;
	private String matchtime;
	private Boolean status;
	private SportDTO sportDTO;
	private Set<UserDTO> joinersDTO;
	private Set<UserDTO> invitedDTO;
	private int joinersInt;
	private Set<TeamDTO> teamsDTO;
}