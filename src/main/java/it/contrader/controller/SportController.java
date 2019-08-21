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

import it.contrader.dto.EventDTO;
//import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.SportService;
import it.contrader.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sport")
public class SportController extends AbstractController<SportDTO>{

	@Autowired
	private SportService sportService;
	
	//@Autowired
	//public SportController(SportService sportService) {
	//	this.sportService = sportService;	
		
		
		//POST Angular a SportDTO
		@PostMapping(value = "/sportmanager")
		public SportDTO sportmanager( @RequestBody SportDTO sportDTO ) {
			return sportService.findByName(sportDTO.getName());
		}
	}
	