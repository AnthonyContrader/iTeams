package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.EventDTO;
//import it.contrader.dto.FeedbackDTO;
import it.contrader.service.EventService;


@RestController
@CrossOrigin
@RequestMapping("/event")

public class EventController extends AbstractController<EventDTO>{

	@Autowired
	private EventService eventService;
	
	//@Autowired
	//public EventController(EventService eventService) {
	//	this.eventService = eventService;	
		
		
		//POST Angular a EventDTO
		/*@PostMapping(value = "/eventmanager")
		public EventDTO eventmanager( @RequestBody EventDTO eventDTO ) {
			return eventService.findById(eventDTO.getId());
		}*/
	}