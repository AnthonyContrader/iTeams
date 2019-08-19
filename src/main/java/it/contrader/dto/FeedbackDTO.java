package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
	
	private int id;
	private SportDTO sportDTO;
	private UserDTO userDTO;
	private UserDTO creatorDTO;
	private int rate;
}