package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import it.contrader.dto.EventDTO;
//import it.contrader.dto.FeedbackDTO;
//import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Event;
//import it.contrader.model.Sport;
import it.contrader.model.User;

@Component
public class EventConverter  extends AbstractConverter<Event,EventDTO> {

	
	@Override
	public EventDTO toDTO(Event event) {
		EventDTO eventDTO = null;
		if (event != null) {
			eventDTO = new EventDTO();
			eventDTO.setId(event.getId());
			eventDTO.setSportName(event.getSportName());
			//eventDTO.setUserDTO(ConverterUser.toDTO(event.getUser()));
			//eventDTO.setUserName(event.getUserName());
			eventDTO.setRate(event.getRate());
			eventDTO.setCity(event.getCity());
			eventDTO.setAddress(event.getAddress());
			eventDTO.setMatchtime(event.getMatchtime());
			eventDTO.setStatus(event.isStatus());
			//eventDTO.setSportDTO(SportConverter.toDTO(event.getSport()));
			//eventDTO.setJoinersInt(event.getJoiners().size());
			//eventDTO.setInvitedDTO(UserConverter.toSetDTO(event.getInvited()));
			//eventDTO.setJoinersDTO(UserConverter.toSetDTO(event.getJoiners()));
			//eventDTO.setTeamsDTO(TeamConverter.toSetDTO(event.getTeams()));
		}
		return eventDTO;
		
	}
	
	@Override
	public Event toEntity(EventDTO eventDTO) {
		Event event = null;
		if (eventDTO !=null) {
			event = new Event ();
			event.setSportName(eventDTO.getSportName());
			//event.setUserName(eventDTO.getUserName());
			//event.setUser(UserConverter.toEntity((eventDTO.getUserDTO())));
			event.setId(eventDTO.getId());
			event.setRate(eventDTO.getRate());
			event.setCity(eventDTO.getCity());
			event.setAddress(eventDTO.getAddress());
			event.setMatchtime(eventDTO.getMatchtime());
			event.setStatus(eventDTO.isStatus());
			/*event.setSport(SportConverter.toEntity(eventDTO.getSportDTO()));
			event.setJoiners(UseConverterr.toSetEntity(eventDTO.getJoinersDTO()));
			event.setInvited(UserConverter.toSetEntity(eventDTO.getInvitedDTO()));
			event.setTeams(TeamConverter.toSetEntity(eventDTO.getTeamsDTO()));*/
		}
		return event;
	
			
	}
	

}
