package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterEvent;
import it.contrader.dao.EventRepository;
import it.contrader.dto.EventDTO;
import it.contrader.model.Event;

@Service
public class EventService {

	private final EventRepository eventRepository;

	@Autowired
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public List<EventDTO> getListaEventDTO() {
		return ConverterEvent.toListDTO((List<Event>) eventRepository.findAll());
	}

	public EventDTO getEventDTOById(Integer id) {
		return ConverterEvent.toDTO(eventRepository.findById(id).get());
	}


	public boolean insertEvent(EventDTO eventDTO) {
		return eventRepository.save(ConverterEvent.toEntity(eventDTO)) != null;
	}

	public boolean updateEvent(EventDTO eventDTO) {
		return eventRepository.save(ConverterEvent.toEntity(eventDTO)) != null;
	}
	
	public void deleteEventById(Integer id) {
		eventRepository.deleteById(id);
	}
	
	public List<EventDTO> findEventDTOByCity(String city) {
		final List<Event> list = eventRepository.findAllByCity(city);
		final List<EventDTO> eventDTOs = new ArrayList<>();
		list.forEach(i -> eventDTOs.add(ConverterEvent.toDTO(i)));
		return eventDTOs;
	}
	
	public List<EventDTO> findEventDTOByMatchtime(String matchtime) {
		final List<Event> list = eventRepository.findAllByMatchtime(matchtime);
		final List<EventDTO> eventDTOs = new ArrayList<>();
		list.forEach(i -> eventDTOs.add(ConverterEvent.toDTO(i)));
		return eventDTOs;
	}
}
