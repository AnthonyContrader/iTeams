package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dao.UserRepository;
import it.contrader.dto.EventDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.services.EventService;
import it.contrader.services.SportService;
import it.contrader.services.UserService;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/Event")
public class EventController {

	private final EventService eventService;
	private final SportService sportService;
	private final UserService userService;
	private HttpSession session;
	
	@Autowired
	public EventController(EventService eventService, SportService sportService, UserService userService) {
		this.eventService = eventService;
		this.sportService = sportService;
		this.userService = userService;
	}

	private void visualEvent(HttpServletRequest request){
		System.out.println("in visualEvent()");
		List<EventDTO> allEvent= this.eventService.getListaEventDTO();
		request.setAttribute("allEventDTO", allEvent);
	}
	
	private void visualSport(HttpServletRequest request){
		List<SportDTO> allSport= this.sportService.getListaSportDTO();
		request.setAttribute("allSportDTO", allSport);
	}
	
	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser= this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	@RequestMapping(value = "/eventmanager", method = RequestMethod.GET)
	public String eventmanager(HttpServletRequest request) {
		visualSport(request);
		visualEvent(request);
		return "/event/eventmanager";		
	}
	
	@RequestMapping(value = "/invitedevent", method = RequestMethod.GET)
	public String invitedevent(HttpServletRequest request) {
		session = request.getSession();
		
		User user = userService.getUserById(Integer.parseInt(session.getAttribute("id").toString()));
		visualSport(request);
		visualEvent(request);
		session.setAttribute("utente", user);
		return "/event/invitedevent";		
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
	
	@RequestMapping(value = "/insertevent", method = RequestMethod.POST)
	public String insertevent(HttpServletRequest request) {
//		String sportName = request.getParameter("sportname").toString();
//		String userName = request.getParameter("username").toString();
		session= request.getSession();
		UserDTO userLogged = (UserDTO) session.getAttribute("utenteCollegato");
		//UserDTO creator = new UserDTO();
		//creator.setId(Integer.parseInt(request.getParameter("creator").toString()));
		Integer rate =  Integer.parseInt(request.getParameter("rate").toString());
		String city = request.getParameter("city").toString();
		String address = request.getParameter("address").toString();
		String matchtime= request.getParameter("time").toString();
		SportDTO sportDTO =  sportService.getSportDTOById(Integer.parseInt(request.getParameter("idsport").toString()));
		Set<UserDTO> joiners = new HashSet<>();
		joiners.add(userLogged);
		Set<TeamDTO> teams = new HashSet<>();
		Set<UserDTO> invited = new HashSet<>();
		//Boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		
		//EventDTO eventObj = new EventDTO(0, sportName, userName, rate, city, address, matchtime, status);
		EventDTO eventObj = new EventDTO();
		eventObj.setUserDTO(userLogged);
		eventObj.setRate(rate);
		eventObj.setCity(city);
		eventObj.setAddress(address);
		eventObj.setMatchtime(matchtime);
		eventObj.setStatus(false);
		eventObj.setSportDTO(sportDTO);
		
		eventObj.setJoinersDTO(joiners);
		eventObj.setInvitedDTO(invited);
		eventObj.setTeamsDTO(teams);
		//userLogged.getJoinEventDTO().add(eventObj);
		eventService.insertEvent(eventObj);
//		Set<UserDTO> likes = sportDTO.getLikesDTO();
//		for(UserDTO u : likes) {
//			
//		}
		visualSport(request);
		visualEvent(request);
		return "/event/eventmanager";
	}
	
	@RequestMapping(value = "/redirectinvite", method = RequestMethod.GET)
	public String redirectInvite(HttpServletRequest request) {
		session = request.getSession();
		System.out.println("in redirect invite user");
		//System.out.println("idUser in request: "+request.getParameter("idUpdate"));
		int idEvent = Integer.parseInt(request.getParameter("idEvent"));
//		System.out.println("iduser: "+idUser);
//		UserDTO user = userService.getUserDTOById(idUser);
//		request.setAttribute("user", user);
		EventDTO evento = eventService.getEventDTOById(idEvent);
		session.setAttribute("evento", evento);
		visualUser(request);
		return "/user/inviteuser";
	}
	
	@RequestMapping(value = "/inviteuser", method = RequestMethod.GET)
	public String inviteuser(HttpServletRequest request)
	{	
		session = request.getSession();
		//List<EventDTO> createdEvents = eventService.getListaEventDTOByUser(Integer.parseInt(session.getAttribute("id").toString()));
		int idUtente = Integer.parseInt(request.getParameter("idInvite").toString());
		EventDTO evento = (EventDTO)session.getAttribute("evento");
			
		evento.getInvitedDTO().add(userService.getUserDTOById(idUtente));
		eventService.updateEvent(evento);
		visualEvent(request);
		//visualUser(request);
		visualSport(request);
		System.out.println("dopo visual event e user");
		return "/event/eventmanager";	
		
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
