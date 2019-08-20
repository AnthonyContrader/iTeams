package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.EventConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.EventRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.EventDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Event;
import it.contrader.model.User;

@Service
public class EventService extends AbstractService<Event,EventDTO> {

	//ALL crud methods in AbstractService
	
	
	
	public EventDTO findById(long id) {
		return converter.toDTO(((EventRepository)repository).findById(id));
	}
	
	}

