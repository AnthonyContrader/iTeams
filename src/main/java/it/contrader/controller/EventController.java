package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.EventDTO;
import it.contrader.services.EventService;
import it.contrader.services.UserService;

import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping("/Event")
public class EventController {

	private final EventService eventService;
	private HttpSession session;
	
	@Autowired
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	private void visualEvent(HttpServletRequest request){
		List<EventDTO> allEvent= this.eventService.getListaEventDTO();
		request.setAttribute("allEventDTO", allEvent);
	}
	
	@RequestMapping(value = "/eventmanager", method = RequestMethod.GET)
	public String eventmanager(HttpServletRequest request) {
		visualEvent(request);
		return "homeEvent";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.eventService.deleteEventById(id);
		visualEvent(request);
		return "homeUser";
		
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualEvent(request);
		request.setAttribute("option", "insert");
		return "creaUser";
		
	}
	
	@RequestMapping(value = "/findEvent", method = RequestMethod.GET)
	public String cercaMatch(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<EventDTO> allEvent= this.eventService.findEventDTOByCity(content);
		request.setAttribute("allEventDTO", allEvent);

		return "homeEvent";

	}
	
	@RequestMapping(value = "/creaEvent", method = RequestMethod.POST)
	public String insertEvent(HttpServletRequest request) {
		String sportName = request.getParameter("sportname").toString();
		String userName = request.getParameter("username").toString();
		Integer rate =  Integer.parseInt(request.getParameter("rate").toString());
		String city = request.getParameter("city").toString();
		String address = request.getParameter("address").toString();
		String matchtime= request.getParameter("matchtime").toString();
		Boolean status = Boolean.parseBoolean(request.getParameter("status"));

		EventDTO eventObj = new EventDTO(0, sportName, userName, rate, city, address, matchtime, status);
		
		eventService.insertEvent(eventObj);

		visualEvent(request);
		return "homeEvent";
	}
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String ruolo = userDTO.getRuolo();
		if (!StringUtils.isEmpty(ruolo)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (ruolo.equals("ADMIN")) {
				return "home";
			} else if (ruolo.equals("CHATMASTER")) {
				return "home";
			}
		}
		return "index";
	}*/
}
