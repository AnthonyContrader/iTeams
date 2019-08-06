package it.contrader.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {

	private Integer id;
	private String sportName;
	private String userName;
	private Integer rate;
	private String city;
	private String address;
	private Date matchtime;
	private Boolean status;

}