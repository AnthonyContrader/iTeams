package it.contrader.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SportDTO {

	private long id;
	private String name;
	private long players;
	private Set<FeedbackDTO> sportfeedDTO;
	private Set<UserDTO> likes;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		//result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (players ^ (players >>> 32));
		//result = prime * result + ((sportfeedDTO == null) ? 0 : sportfeedDTO.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		SportDTO other = (SportDTO) obj;
		if(this.name.equalsIgnoreCase(other.getName())) {
			return true;
		}
		return false;
	}
	
	/*private Set<EventDTO> eventsDTO;*/
	
	
	
	
}
