package it.contrader.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
	
	private int id;
	private int idSport;
	private int idUser;
	private int rate;

}
