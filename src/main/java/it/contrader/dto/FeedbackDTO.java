package it.contrader.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
	
	private long id;
	private SportDTO sportDTO;
	private UserDTO userDTO;
	private UserDTO creatorDTO;
	private int rate;
	
	@Override
	public String toString() {
		return "FeedbackDTO [id=" + id + ", sportDTO=" + sportDTO + ", userDTO=" + userDTO + ", creatorDTO="
				+ creatorDTO + ", rate=" + rate + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creatorDTO == null) ? 0 : creatorDTO.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + rate;
		result = prime * result + ((userDTO == null) ? 0 : userDTO.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackDTO other = (FeedbackDTO) obj;
		if (creatorDTO == null) {
			if (other.creatorDTO != null)
				return false;
		} else if (!creatorDTO.equals(other.creatorDTO))
			return false;
		if (id != other.id)
			return false;
		if (rate != other.rate)
			return false;
		if (userDTO == null) {
			if (other.userDTO != null)
				return false;
		} else if (!userDTO.equals(other.userDTO))
			return false;
		return true;
	}	
}