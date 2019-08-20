package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import it.contrader.dto.EventDTO;
//import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.EventService;
import it.contrader.service.SportService;
import it.contrader.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
		@PostMapping(value = "/eventmanager")
		public EventDTO login( @RequestBody EventDTO eventDTO ) {
			return eventService.findById(eventDTO.getId());
		}
	}