package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import it.contrader.dto.EventDTO;
//import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Sport;
import it.contrader.model.User;

@Component
public class SportConverter  extends AbstractConverter<Sport,SportDTO> {

	
	@Override
	public SportDTO toDTO(Sport sport) {
		SportDTO sportDTO = null;
		if (sport != null) {
			sportDTO = new SportDTO();
			sportDTO.setId(sport.getId());
			sportDTO.setName(sport.getName());
			sportDTO.setPlayers(sport.getPlayers());
			UserConverter uc = new UserConverter();
			sportDTO.setLikes(uc.toDTOSet(sport.getLikes()));
//			sportDTO.setEventsDTO(ConverterEvent.toSetDTO(sport.getEvents()));
//			sportDTO.setLikesDTO(ConverterUser.toSetDTO(sport.getLikes()));
//			sportDTO.setSportfeedDTO(ConverterFeedback.toSetDTO(sport.getSportfeed()));
		}
		return sportDTO;
		
	}
	
	@Override
	public Sport toEntity(SportDTO sportDTO) {
		Sport sport = null;
		if (sportDTO !=null) {
			sport = new Sport ();
			sport.setId(sportDTO.getId());
			sport.setName(sportDTO.getName());
			sport.setPlayers(sportDTO.getPlayers());
//			sport.setEvents(ConverterEvent.toSetEntity(sportDTO.getEventsDTO()));
			UserConverter uc = new UserConverter();
			sport.setLikes(uc.toEntitySet(sportDTO.getLikes()));
//			sport.setSportfeed(ConverterFeedback.toSetEntity(sportDTO.getSportfeedDTO()));
		}
		return sport;
			
	}

	@Override
	public Sport toEntityS(SportDTO sportDTO) {
		Sport sport = null;
		System.out.println("in sport converter to entityS");
		if (sportDTO !=null) {
			sport = new Sport ();
			sport.setId(sportDTO.getId());
			sport.setName(sportDTO.getName());
			System.out.println("sportDTO name: "+sportDTO.getName());
			
			System.out.println("sport name: "+sport.getName());
			sport.setPlayers(sportDTO.getPlayers());
//			sport.setEvents(ConverterEvent.toSetEntity(sportDTO.getEventsDTO()));
//			sport.setSportfeed(ConverterFeedback.toSetEntity(sportDTO.getSportfeedDTO()));
		}
		return sport;
	}

	@Override
	public SportDTO toDTOS(Sport sport) {
		SportDTO sportDTO = null;
		System.out.println("in sport converter to dtoS");
		if (sport != null) {
			sportDTO = new SportDTO();
			sportDTO.setId(sport.getId());
			sportDTO.setName(sport.getName());
			sportDTO.setPlayers(sport.getPlayers());
			System.out.println("sportDTO name: "+sportDTO.getName());
			
			System.out.println("sport name: "+sport.getName());
//			sportDTO.setEventsDTO(ConverterEvent.toSetDTO(sport.getEvents()));
//			sportDTO.setLikesDTO(ConverterUser.toSetDTO(sport.getLikes()));
//			sportDTO.setSportfeedDTO(ConverterFeedback.toSetDTO(sport.getSportfeed()));
		}
		return sportDTO;
	}
	

}
