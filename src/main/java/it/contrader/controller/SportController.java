package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.SportService;
import it.contrader.services.UserService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Sport")

public class SportController {

	private final SportService sportService;
	private HttpSession session;

	@Autowired
	public SportController(SportService sportService) {
		this.sportService = sportService;	
	}
	
	@RequestMapping(value = "/sportManagement", method = RequestMethod.GET)
	public String sportManagement(HttpServletRequest request) {
		request.setAttribute("sport", getSport());
		return "sport/sportManagement";
	}

	public List<SportDTO> getSport() {
		List<SportDTO> tmp = sportService.getListaSportDTO();
		List<SportDTO> sportList = new ArrayList<>();
		for (UserDTO sport : tmp) {
			if (sport.getSporttype() != "") {
				sportList.add(sport);
			}
		}

		return sportList;
	}		
	
	@RequestMapping(value ="/deleteSport", method = RequestMethod.GET)
	public String deleteSport(HttpServletRequest request) {
		int idSport = Integer.parseInt(request.getParameter("id"));
		sportService.deleteSportById(idSport);
		request.setAttribute("sport", getSport());
		return "sport/sportManagement";
	}
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idSport = Integer.parseInt(request.getParameter("id"));
		SportDTO sport = sportService.getSportDTOById(idSport);
		request.setAttribute("sport", sport);
		return "sport/updateSport";
	}
	
	@RequestMapping(value = "/updateSport", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String nameUpdate = request.getParameter("name");
		Integer PlayersUpdate = request.getParameter("players");
	
		
			
		final SportDTO sport = new SportDTO(nameUpdate,playersUpdate);
		sport.setId(idUpdate);
		
		sportService.updateSport(sport);
		request.setAttribute("sport", getSport());
		return "sport/sportManagement";	
		
	}
	
	
	@RequestMapping(value = "/insertSport", method = RequestMethod.POST)
	public String insertSport(HttpServletRequest request) {
		
		String name= request.getParameter("name");
		Integer players= Integer.parseInt(request.getParameter("players"));
		
		
		
		SportDTO sportDTO = new SportDTO(name,players);
		
		sportService.insertSport(sportDTO);
		
		request.setAttribute("sport", getSport());
		
		return "sport/sportManagement";		
	}
}