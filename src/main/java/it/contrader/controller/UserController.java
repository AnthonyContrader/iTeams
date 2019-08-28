package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.EventDTO;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.MessageDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;


/**
 * 
 * Questa classe estende AbstractController con tipo UserDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<UserDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserDTO>{
	
	@Autowired
	private UserService userService;

	//POST Angular a UserDTO
	@PostMapping(value = "/login")
	public UserDTO login( @RequestBody LoginDTO loginDTO ) {
		return userService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
	}
	
	@PostMapping(value = "/geteventcreated")
	public Iterable<EventDTO> getEventCreated( @RequestBody UserDTO userDTO ) {
		UserDTO io = userService.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
		return io.getCreatedEvents();		
	}
	
	@PostMapping(value = "/getliked")
	public Iterable<SportDTO> getSportCreated( @RequestBody UserDTO userDTO ) {
		UserDTO io = userService.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
		return io.getLike();		
	}
	
	@PostMapping(value = "/getreceivedmsg")
	public Iterable<MessageDTO> getMsgReceived( @RequestBody UserDTO userDTO ) {
		UserDTO io = userService.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
		return io.getReceivedmsg();		
	}
	
	@PostMapping(value = "/getsentmsg")
	public Iterable<MessageDTO> getMsgSent( @RequestBody UserDTO userDTO ) {
		UserDTO io = userService.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
		return io.getSentmsg();		
	}
	
}