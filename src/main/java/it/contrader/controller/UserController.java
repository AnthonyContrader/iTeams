package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private HttpSession session;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
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
		return "usermanager";		
	}
	
	@RequestMapping(value = "/readuser", method = RequestMethod.GET)
	public String readuser(HttpServletRequest request) {
		thisUser(request,session.getAttribute("username").toString());
		return "/user/readuser";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.deleteUserById(id);
		visualUser(request);
		return "homeUser";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualUser(request);
		request.setAttribute("option", "insert");
		return "creaUser";
		
	}
	
	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
		request.setAttribute("allUserDTO", allUser);

		return "homeUser";

	}
	
	@RequestMapping(value = "/creaUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String usertype = request.getParameter("usertype").toString();
		Boolean status = Boolean.parseBoolean(request.getParameter("status"));

		UserDTO userObj = new UserDTO(0, username, password, usertype, status);
		
		userService.insertUser(userObj);

		visualUser(request);
		return "homeUser";
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
			if (usertype.toUpperCase().equals("ADMIN")) {
				
				request.setAttribute("utente", userDTO.getUsername());
				return "homeadmin";
				
			} else if (usertype.toUpperCase().equals("USER")) {
				
				request.setAttribute("utente", userDTO.getUsername());
				return "homeuser";
			}
		}
		return "index";
	}
}
