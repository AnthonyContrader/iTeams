package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EventDTO;
import it.contrader.model.Event;

public class ConverterEvent{

	public static EventDTO toDTO(Event event) {
		EventDTO eventDTO = null;
		if (event != null) {
			eventDTO = new EventDTO();
			eventDTO.setId(event.getId());
			eventDTO.setSportName(event.getSportName());
			eventDTO.setUserName(event.getUserName());
			eventDTO.setRate(event.getRate());
			eventDTO.setCity(event.getCity());
			eventDTO.setAddress(event.getAddress());
			eventDTO.setMatchtime(event.getMatchtime());
			//matchDTO.setStatus(match.isStatus());
		}
		return eventDTO;
	}

	public static Event toEntity(EventDTO eventDTO) {
		Event event = null;
		if (eventDTO != null) {
			event = new Event();
			event.setId(eventDTO.getId());
			event.setSportName(eventDTO.getSportName());
			event.setUserName(eventDTO.getUserName());
			event.setRate(eventDTO.getRate());
			event.setCity(eventDTO.getCity());
			event.setAddress(eventDTO.getAddress());
			event.setMatchtime(eventDTO.getMatchtime());
			//match.setStatus(matchDTO.getStatus());
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
}
