package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import it.contrader.dto.EventDTO;
import it.contrader.model.Event;


public class ConverterEvent{

	public static EventDTO toDTO(Event event) {
		EventDTO eventDTO = null;
		if (event != null) {
			eventDTO = new EventDTO();
			eventDTO.setId(event.getId());
			//eventDTO.setSportName(event.getSportName());
			eventDTO.setUserDTO(ConverterUser.toDTO(event.getUser()));
			//eventDTO.setUserName(event.getUserName());
			eventDTO.setRate(event.getRate());
			eventDTO.setCity(event.getCity());
			eventDTO.setAddress(event.getAddress());
			eventDTO.setMatchtime(event.getMatchtime());
			eventDTO.setStatus(event.getStatus());
			eventDTO.setSportDTO(ConverterSport.toDTO(event.getSport()));
			eventDTO.setJoinersInt(event.getJoiners().size());
			eventDTO.setInvitedDTO(ConverterUser.toSetDTO(event.getInvited()));
			eventDTO.setJoinersDTO(ConverterUser.toSetDTO(event.getJoiners()));
			eventDTO.setTeamsDTO(ConverterTeam.toSetDTO(event.getTeams()));
		}
		return eventDTO;
	}

	public static Event toEntity(EventDTO eventDTO) {
		Event event = null;
		if (eventDTO != null) {
			event = new Event();
			event.setId(eventDTO.getId());
			//event.setSportName(eventDTO.getSportName());
			//event.setUserName(eventDTO.getUserName());
			event.setUser(ConverterUser.toEntity((eventDTO.getUserDTO())));
			event.setRate(eventDTO.getRate());
			event.setCity(eventDTO.getCity());
			event.setAddress(eventDTO.getAddress());
			event.setMatchtime(eventDTO.getMatchtime());
			event.setStatus(eventDTO.getStatus());
			event.setSport(ConverterSport.toEntity(eventDTO.getSportDTO()));
			event.setJoiners(ConverterUser.toSetEntity(eventDTO.getJoinersDTO()));
			event.setInvited(ConverterUser.toSetEntity(eventDTO.getInvitedDTO()));
			event.setTeams(ConverterTeam.toSetEntity(eventDTO.getTeamsDTO()));
		}
		return event;
	}

	public static List<EventDTO> toListDTO(List<Event> list) {
		List<EventDTO> listEventDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Event event : list) {
				listEventDTO.add(ConverterEvent.toDTO(event));
			}
		}
		return listEventDTO;
	}

	public static List<Event> toListEntity(List<EventDTO> listEventDTO) {
		List<Event> list = new ArrayList<>();
		if (!listEventDTO.isEmpty()) {
			for (EventDTO eventDTO : listEventDTO) {
				list.add(ConverterEvent.toEntity(eventDTO));
			}
		}
		return list;
	}
	
	public static Set<EventDTO> toSetDTO(Set<Event> set) {
		Set<EventDTO> setEventDTO = new HashSet<>();
		if (!set.isEmpty()) {
			for (Event event : set) {
				setEventDTO.add(ConverterEvent.toDTO(event));
			}
		}
		return setEventDTO;
	}
	
	public static Set<Event> toSetEntity(Set<EventDTO> setEventDTO) {
		Set<Event> set = new HashSet<>();
		if (!setEventDTO.isEmpty()) {
			for (EventDTO eventDTO : setEventDTO) {
				set.add(ConverterEvent.toEntity(eventDTO));
			}
		}
		return set;
	}
}