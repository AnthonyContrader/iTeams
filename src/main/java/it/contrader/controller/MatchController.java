package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.MatchDTO;
import it.contrader.services.MatchService;
import it.contrader.services.UserService;

import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping("/Match")
public class MatchController {

	private final MatchService matchService;
	private HttpSession session;
	
	@Autowired
	public MatchController(MatchService matchService) {
		this.matchService = matchService;
	}

	private void visualMatch(HttpServletRequest request){
		List<MatchDTO> allMatch = this.matchService.getListaMatchDTO();
		request.setAttribute("allMatchDTO", allMatch);
	}
	
	@RequestMapping(value = "/matchManagement", method = RequestMethod.GET)
	public String matchManagement(HttpServletRequest request) {
		visualMatch(request);
		return "homeMatch";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.matchService.deleteMatchById(id);
		visualMatch(request);
		return "homeUser";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualMatch(request);
		request.setAttribute("option", "insert");
		return "creaUser";
		
	}
	
	@RequestMapping(value = "/cercaMatch", method = RequestMethod.GET)
	public String cercaMatch(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<MatchDTO> allMatch = this.matchService.findMatchDTOByCity(content);
		request.setAttribute("allMatchDTO", allMatch);

		return "homeMatch";

	}
	
	@RequestMapping(value = "/creaMatch", method = RequestMethod.POST)
	public String insertMatch(HttpServletRequest request) {
		String sportName = request.getParameter("sportName").toString();
		String userName = request.getParameter("userName").toString();
		Integer rate =  Integer.parseInt(request.getParameter("rate").toString());
		String city = request.getParameter("city").toString();
		String address = request.getParameter("address").toString();
		String matchtime= request.getParameter("matchtime").toString();
		Boolean status = Boolean.parseBoolean(request.getParameter("status"));

		MatchDTO matchObj = new MatchDTO(0, sportName, userName, rate, city, address, matchtime, status);
		
		matchService.insertMatch(matchObj);

		visualMatch(request);
		return "homeMatch";
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
