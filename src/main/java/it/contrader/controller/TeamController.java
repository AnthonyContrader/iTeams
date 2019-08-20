package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.TeamService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController extends AbstractController<TeamDTO>{
	
	
	@Autowired
	private TeamService teamService;


	//POST Angular a UserDTO
	@PostMapping(value = "/read")
	public TeamDTO read( @RequestBody TeamDTO teamDTO ) {
		return teamService.findById(teamDTO.getId());
	}
}
