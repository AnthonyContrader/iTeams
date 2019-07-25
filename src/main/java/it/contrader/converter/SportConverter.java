package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.SportDTO;
import it.contrader.model.Sport;

public class SportConverter implements Converter<Sport, SportDTO> {

	
	public SportDTO toDTO(Sport sport) {
		SportDTO sportDTO =new SportDTO(sport.getId(), sport.getPlayers(), sport.getName());
		return sportDTO;
	}

	
	public Sport toEntity(SportDTO sportDTO) {
		Sport sport = new Sport(sportDTO.getId(), sportDTO.getPlayers(),sportDTO.getName());
			return sport;
	}

	public List<SportDTO> toDTOList(List<Sport> sportList) {
		List<SportDTO> sportDTOList = new ArrayList<SportDTO>();
		
		for(Sport sport: sportList) {
			sportDTOList.add(toDTO(sport));
		}    
		
		return sportDTOList;
	}
	
}