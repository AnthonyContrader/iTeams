package it.contrader.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.User;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EventDTO {

	private long id;
	//private String sportName;
	private UserDTO creator;
	private long rate;
	private String city;
	private String address;
	private String matchtime;
	private boolean status;
	private SportDTO sport;
	private Set<UserDTO> notify;
/*	private Set<UserDTO> joinersDTO;
	private Set<UserDTO> invitedDTO;
	private long joinersInt;
	private Set<TeamDTO> teamsDTO;*/
}