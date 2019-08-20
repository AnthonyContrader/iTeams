package it.contrader.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventDTO {

	private long id;
	private String sportName;
	//private UserDTO userDTO;
	private long rate;
	private String city;
	private String address;
	private String matchtime;
	private Boolean status;
	/*private SportDTO sportDTO;
	private Set<UserDTO> joinersDTO;
	private Set<UserDTO> invitedDTO;*/
	private long joinersInt;
	//private Set<TeamDTO> teamsDTO;
}