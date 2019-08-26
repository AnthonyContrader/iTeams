package it.contrader.dto;

import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
	
	private long id;
	
	//private String sportName;
	
	//private String userName;
	
	private String creatorName;
	
	private int rate;
	
	private UserDTO user;
	
	private SportDTO sport;
}
