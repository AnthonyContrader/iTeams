package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SportDTO;
import it.contrader.model.Sport;

public class SportConverter implements Converter <Sport, SportDTO> {

	@Override
	public SportDTO toDTO(Sport sport) {
		SportDTO sportDTO = new SportDTO(sport.getId(), sport.getName(),sport.getPlayers());
		return sportDTO;
	}

	@Override
	public Sport toEntity(SportDTO sportDTO) {
		Sport sport = new Sport(sportDTO.getId(), sportDTO.getName(),sportDTO.getPlayers());
		return sport;
	}

	@Override
	public List<SportDTO> toDTOList(List<Sport> sportList) {
		List<SportDTO> sportDTOlist = new ArrayList<SportDTO>();
		for(Sport sport: sportList) {
			sportDTOlist.add(toDTO(sport));
		}
		return sportDTOlist;
	}
	
}
