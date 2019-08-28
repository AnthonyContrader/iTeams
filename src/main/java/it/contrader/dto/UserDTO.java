package it.contrader.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Feedback;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see User
 */
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class UserDTO {

	private long id;
	
	private String username;
	
	private String password="";

	private Usertype usertype;
	
	private boolean status;
	
	private Set<FeedbackDTO> received=null;
	
	private Set<SportDTO> like;
	
	private Set<MessageDTO> receivedmsg;
	
	private Set<MessageDTO> sentmsg;
	
	private Set<EventDTO> createdEvents;

}
