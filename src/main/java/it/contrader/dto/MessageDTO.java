package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class MessageDTO {
	
	private long id;
	private String text;
	private UserDTO sender;
	private UserDTO receiver;

}
