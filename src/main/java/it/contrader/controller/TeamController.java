package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.TeamService;
import it.contrader.services.UserService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Team")

public class TeamController {

	private final TeamService teamService;
	private HttpSession session;

	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;	
	}
	
	@RequestMapping(value = "/teammanager", method = RequestMethod.GET)
	public String teamManagement(HttpServletRequest request) {
		request.setAttribute("team", getTeam());
		return "team/teammanager";
	}

	public List<TeamDTO> getTeam() {
		List<TeamDTO> tmp = teamService.getListaTeamDTO();
		List<TeamDTO> teamList = new ArrayList<>();
		for (TeamDTO team : tmp) {
			
				teamList.add(team);
			
		}

		return teamList;
	}		
	
	@RequestMapping(value ="/deleteTeam", method = RequestMethod.GET)
	public String deleteTeam(HttpServletRequest request) {
		int idTeam = Integer.parseInt(request.getParameter("id"));
		teamService.deleteTeamById(idTeam);
		request.setAttribute("team", getTeam());
		return "team/teammanager";
	}
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idTeam = Integer.parseInt(request.getParameter("id"));
		TeamDTO team = teamService.getTeamDTOById(idTeam);
		request.setAttribute("team", team);
		return "team/updateteam";
	}
	
	@RequestMapping(value = "/updateteam", method = RequestMethod.POST)
	public String updateTeam(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
		String nameUpdate = request.getParameter("name");
		Integer playersUpdate = Integer.parseInt(request.getParameter("players"));
		Integer idSportUpdate = Integer.parseInt(request.getParameter("idsport"));
		
			
		final TeamDTO team = new TeamDTO(idUpdate, nameUpdate, idSportUpdate, playersUpdate);
		
		teamService.updateTeam(team);
		request.setAttribute("team", getTeam());
		return "team/teammanager";	
		
	}
	
	
	@RequestMapping(value = "/insertteam", method = RequestMethod.POST)
	public String insertTeam(HttpServletRequest request) {
		
		String name= request.getParameter("name");
		Integer players= Integer.parseInt(request.getParameter("players"));
		Integer idSport = Integer.parseInt(request.getParameter("idsport"));
				
		TeamDTO teamDTO = new TeamDTO(0, name,idSport, players);
		
		teamService.insertTeam(teamDTO);
		
		request.setAttribute("team", getTeam());
		
		return "team/teammanager";		
	}
}