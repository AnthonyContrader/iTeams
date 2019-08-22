package it.contrader.dto;

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
	
	private String sportName;
	
	private String userName;
	
	private String creatorName;
	
	private int rate;
	
}
