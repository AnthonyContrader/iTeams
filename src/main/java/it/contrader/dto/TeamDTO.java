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
public class TeamDTO {
	
	private long id;
	private String name;
	private EventDTO eventDTO;
	private Set<UserDTO> componentsDTO;
	
	@Override
	public String toString() {
		return "TeamDTO [id=" + id + ", name=" + name + ", eventDTO=" + eventDTO + ", componentsDTO=" + componentsDTO
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentsDTO == null) ? 0 : componentsDTO.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		TeamDTO other = (TeamDTO) obj;
		if (componentsDTO == null) {
			if (other.componentsDTO != null)
				return false;
		} else if (!componentsDTO.equals(other.componentsDTO))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}