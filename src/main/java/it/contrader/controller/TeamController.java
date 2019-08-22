package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;


import it.contrader.dto.LoginDTO;
import it.contrader.dto.TeamDTO;

import it.contrader.service.TeamService;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/team")
public class TeamController extends AbstractController<TeamDTO>{

	@Autowired
	private TeamService teamService;
	
	//@Autowired
	//public TeamController(TeamService teamService) {
	//	this.teamService = teamService;	
		
		
		//POST Angular a TeamDTO
		@PostMapping(value = "/teammanager")
		public TeamDTO teammanager( @RequestBody TeamDTO teamDTO ) {
			return teamService.findByName(teamDTO.getName());
		}
	}
	