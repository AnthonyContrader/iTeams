package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.contrader.dto.EventDTO;
import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Sport;


public class ConverterSport {
	
	public static SportDTO toDTO(Sport sport) {
		SportDTO sportDTO = null;
		if (sport != null) {
			sportDTO = new SportDTO();
			sportDTO.setId(sport.getId());
			sportDTO.setName(sport.getName());
			sportDTO.setPlayers(sport.getPlayers());
//			sportDTO.setEventsDTO(ConverterEvent.toSetDTO(sport.getEvents()));
//			sportDTO.setLikesDTO(ConverterUser.toSetDTO(sport.getLikes()));
//			sportDTO.setSportfeedDTO(ConverterFeedback.toSetDTO(sport.getSportfeed()));
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
//			sport.setEvents(ConverterEvent.toSetEntity(sportDTO.getEventsDTO()));
//			sport.setLikes(ConverterUser.toSetEntity(sportDTO.getLikesDTO()));
//			sport.setSportfeed(ConverterFeedback.toSetEntity(sportDTO.getSportfeedDTO()));
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
	
	public static Set<SportDTO> toSetDTO(Set<Sport> set) {
		Set<SportDTO> setSportDTO = new HashSet<>();
		if (!set.isEmpty()) {
			for (Sport sport: set) {
				setSportDTO.add(ConverterSport.toDTO(sport));
			}
		}
		return setSportDTO;
	}
	
	public static Set<Sport> toSetEntity(Set<SportDTO> setSportDTO) {
		Set<Sport> set = new HashSet<>();
		if (!setSportDTO.isEmpty()) {
			for (SportDTO sportDTO : setSportDTO) {
				set.add(ConverterSport.toEntity(sportDTO));
			}
		}
		return set;
	}

	
}
	



	