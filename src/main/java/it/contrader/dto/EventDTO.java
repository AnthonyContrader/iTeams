package it.contrader.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

	private int id;
	private String sportName;
	private String userName;
	private int rate;
	private String city;
	private String address;
	private String matchtime;
	private Boolean status;

}