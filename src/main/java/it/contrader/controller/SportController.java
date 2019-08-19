package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.EventDTO;
import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.SportService;
import it.contrader.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;
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
	
	@RequestMapping(value = "/sportmanager", method = RequestMethod.GET)
	public String sportManagement(HttpServletRequest request) {
		request.setAttribute("sport", getSport());
		System.out.println("dopo request setA");
		for(SportDTO sport: getSport())
			System.out.println(sport.getName());
		return "/sport/sportmanager";
	}

	public List<SportDTO> getSport() {
		System.out.println("in getSport()");
		List<SportDTO> tmp = sportService.getListaSportDTO();
		System.out.println("lista tmp creata");
		List<SportDTO> sportList = new ArrayList<>();
		for (SportDTO sport : tmp) {
			System.out.println("nel for");
				sportList.add(sport);
			
		}
		System.out.println("fuori dal for");
		return sportList;
	}		
	
	@RequestMapping(value ="/deletesport", method = RequestMethod.GET)
	public String deleteSport(HttpServletRequest request) {
		int idSport = Integer.parseInt(request.getParameter("id"));
		sportService.deleteSportById(idSport);
		request.setAttribute("sport", getSport());
		return "/sport/sportmanager";
	}
	
	@RequestMapping(value = "/redirectupdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		System.out.println("in redirect update sport");
		System.out.println("idSport in request: "+request.getParameter("idUpdate"));
		int idSport = Integer.parseInt(request.getParameter("idUpdate"));
		System.out.println("idSport: "+idSport);
		SportDTO sport = sportService.getSportDTOById(idSport);
		request.setAttribute("sport", sport);
		return "/sport/updatesport";
	}
	
	@RequestMapping(value = "/updatesport", method = RequestMethod.POST)
	public String updateSport(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String nameUpdate = request.getParameter("name");
		Integer playersUpdate = Integer.parseInt(request.getParameter("players"));
	
		
			
		//final SportDTO sport = new SportDTO(nameUpdate, PlayersUpdate);
		//final SportDTO sport = new SportDTO();
		final SportDTO sport= sportService.getSportDTOById(idUpdate);
		//sport.setId(idUpdate);
		sport.setName(nameUpdate);
		sport.setPlayers(playersUpdate);
		
		sportService.updateSport(sport);
		request.setAttribute("sport", getSport());
		return "sport/sportmanager";	
		
	}
	
	
	@RequestMapping(value = "/insertsport", method = RequestMethod.POST)
	public String insertSport(HttpServletRequest request) {
		
		String name= request.getParameter("name");
		Integer players= Integer.parseInt(request.getParameter("players"));
		
		
		
		//SportDTO sportDTO = new SportDTO(name,players);
		SportDTO sportDTO = new SportDTO();
		sportDTO.setName(name);
		sportDTO.setPlayers(players);
		sportDTO.setEventsDTO(new HashSet<EventDTO>());
		sportDTO.setSportfeedDTO(new HashSet<FeedbackDTO>());
		
		
		sportService.insertSport(sportDTO);
		
		request.setAttribute("sport", getSport());
		
		return "sport/sportmanager";		
	}
}