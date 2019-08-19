package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.EventDTO;
import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.EventService;
import it.contrader.services.UserService;

import java.util.HashSet;
import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private final EventService eventService;
	private HttpSession session;
	
	@Autowired
	public UserController(UserService userService, EventService eventService) {
		this.userService = userService;
		this.eventService = eventService;
	}

	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	private void thisUser(HttpServletRequest request, String userName){
		List<UserDTO> thisUser = this.userService.findUserDTOByUsername(userName);
		request.setAttribute("dto", thisUser);
	}
	
	@RequestMapping(value = "/usermanager", method = RequestMethod.GET)
	public String usermanager(HttpServletRequest request) {
		visualUser(request);
		return "/user/usermanager";		
	}
	
	@RequestMapping(value = "/readuser", method = RequestMethod.GET)
	public String readuser(HttpServletRequest request) {
		thisUser(request,session.getAttribute("username").toString());
		return "readuser";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.deleteUserById(id);
		visualUser(request);
		return "user/usermanager";
		
	}
	
	@RequestMapping(value = "/redirectupdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		System.out.println("in redirect update user");
		System.out.println("idUser in request: "+request.getParameter("idUpdate"));
		int idUser = Integer.parseInt(request.getParameter("idUpdate"));
		System.out.println("iduser: "+idUser);
		UserDTO user = userService.getUserDTOById(idUser);
		request.setAttribute("user", user);
		return "/user/updateuser";
	}
	
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String updateSport(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate= request.getParameter("password");
		String usertypeUpdate = request.getParameter("usertype");
	
		
			
		//final SportDTO sport = new SportDTO(nameUpdate, PlayersUpdate);
		//final UserDTO user = new UserDTO();
		final UserDTO user= userService.getUserDTOById(idUpdate);
		user.setId(idUpdate);
		user.setUsername(usernameUpdate);
		user.setPassword(passwordUpdate);
		user.setUsertype(usertypeUpdate);
		
		userService.updateUser(user);
		visualUser(request);
		return "user/usermanager";	
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualUser(request);
		request.setAttribute("option", "insert");
		return "creaUser";
		
	}
	
	
	
	
	/*
	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
		request.setAttribute("allUserDTO", allUser);

		return "homeUser";

	}*/
	
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String usertype = request.getParameter("usertype").toString();
		//Boolean status = Boolean.parseBoolean(request.getParameter("status"));

		//UserDTO userObj = new UserDTO(0, username, password, usertype, status);
		UserDTO userObj = new UserDTO();
		//userObj.setId(0);
		userObj.setUsername(username);
		userObj.setPassword(password);
		userObj.setUsertype(usertype);
		userObj.setStatus(true);
		userObj.setCreatedEventsDTO(new HashSet<EventDTO>());
		userObj.setJoinEventDTO(new HashSet<EventDTO>());
		userObj.setMemberOfDTO(new HashSet<TeamDTO>());
		userObj.setLikeDTO(new HashSet<SportDTO>());
		userObj.setGivedDTO(new HashSet<FeedbackDTO>());
		userObj.setReceivedDTO(new HashSet<FeedbackDTO>());
		userService.insertUser(userObj);

		visualUser(request);
		return "user/usermanager";
	}
	
	@RequestMapping(value = "/redirectinvite", method = RequestMethod.GET)
	public String redirectInvite(HttpServletRequest request) {
		System.out.println("in redirect invite user");
		System.out.println("idUser in request: "+request.getParameter("idUpdate"));
		int idUser = Integer.parseInt(request.getParameter("idUpdate"));
		System.out.println("iduser: "+idUser);
		UserDTO user = userService.getUserDTOById(idUser);
		request.setAttribute("user", user);
		return "/user/inviteuser";
	}
	
	@RequestMapping(value = "/inviteuser", method = RequestMethod.POST)
	public String inviteuser(HttpServletRequest request)
	{	
		session = request.getSession();
		//List<EventDTO> createdEvents = eventService.getListaEventDTOByUser(Integer.parseInt(session.getAttribute("id").toString()));
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate= request.getParameter("password");
		String usertypeUpdate = request.getParameter("usertype");
	
		
			
		//final SportDTO sport = new SportDTO(nameUpdate, PlayersUpdate);
		//final UserDTO user = new UserDTO();
		final UserDTO user= userService.getUserDTOById(idUpdate);
		user.setId(idUpdate);
		user.setUsername(usernameUpdate);
		user.setPassword(passwordUpdate);
		user.setUsertype(usertypeUpdate);
		
		userService.updateUser(user);
		visualUser(request);
		return "user/usermanager";	
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String usertype = userDTO.getUsertype();
		System.out.println("Utente:"+ username);
		
		if (!StringUtils.isEmpty(usertype)) {
			session.setAttribute("utenteCollegato", userDTO);
			session.setAttribute("username", userDTO.getUsername());
			session.setAttribute("id", userDTO.getId());
			session.setAttribute("usertype", userDTO.getUsertype());
			if (usertype.toUpperCase().equals("ADMIN")) {
				
				request.setAttribute("utente", userDTO.getUsername());
				return "homeadmin";
				
			} else if (usertype.toUpperCase().equals("USER")) {
				System.out.println("home user");
				request.setAttribute("utente", userDTO.getUsername());
				return "homeuser";
			}
		}
		return "/index";
	}
}
