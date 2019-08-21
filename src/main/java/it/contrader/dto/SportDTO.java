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

public class SportDTO {

	private long id;
	private String name;
	private long players;
	private Set<EventDTO> eventsDTO;
	private Set<UserDTO> likesDTO;
	private Set<FeedbackDTO> sportfeedDTO;
	
	
}
