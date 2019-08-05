package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Sport;
import it.contrader.model.User;


public class ConverterSport {
	
	public static SportDTO toDTO(Sport sport) {
		SportDTO sportDTO = null;
		if (sport != null) {
			sportDTO = new SportDTO();
			sportDTO.setId(sport.getId());
			sportDTO.setName(sport.getName());
			sportDTO.setPlayers(sport.getPlayers());
		}
		return sportDTO;
		
	}
	
	public static Sport toEntity(SportDTO sportDTO) {
		Sport sport = null;
		if (sportDTO !=null) {
			sport = new Sport ();
			sport.setId(sportDTO.getId());
			sport.setName(sportDTO.getName());
			sport.setPlayers(sportDTO.getPlayers());
						
		}
		return sport;
			
	}
	
	public static List<SportDTO> toListDTO(List<Sport> list) {
		List <SportDTO> listSportDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Sport sport : list) {
				listSportDTO.add(ConverterSport.toDTO(sport));
			}
		}
		return listSportDTO;
				
		
	}
	

	public static List<Sport> toListEntity(List<SportDTO> listSportDTO) {
		List<Sport> list = new ArrayList<>();
		if (!listSportDTO.isEmpty()) {
			for (SportDTO sportDTO : listSportDTO) {
				
				list.add(ConverterSport.toEntity(sportDTO));
			}
		}
		return list;
	}

	
}
	



	