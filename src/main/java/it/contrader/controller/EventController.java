package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.EventDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
//import it.contrader.dto.FeedbackDTO;
import it.contrader.service.EventService;
import it.contrader.service.SportService;
import it.contrader.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/event")
public class EventController extends AbstractController<EventDTO>{

	@Autowired
	private EventService eventService;
	@Autowired
	private SportService sportService;
	@Autowired
	private UserService userService;
	
	//@Autowired
	//public EventController(EventService eventService) {
	//	this.eventService = eventService;	
		
	@PostMapping(value = "/notify")
	public void eventmanager( @RequestBody EventDTO eventDTO ) {
		System.out.println("++++++++++in notify");
		EventDTO ev = eventService.findById(eventDTO.getId());
		SportDTO sp= sportService.findByName(eventDTO.getSport().getName());
		System.out.println("sport: "+sp.getName());
		UserDTO u2;
		for(UserDTO u: sp.getLikes()) {
			u2=userService.findByUsername(u.getUsername());
			System.out.println("nel for di notify");
			u2.getNotified().add(eventDTO);
			userService.update(u2);
		}
		
	}
		//POST Angular a EventDTO
		/*@PostMapping(value = "/eventmanager")
		public EventDTO eventmanager( @RequestBody EventDTO eventDTO ) {
			return eventService.findById(eventDTO.getId());
		}*/
	}