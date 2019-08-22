package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.TeamConverter;

import it.contrader.dao.TeamRepository;

import it.contrader.dto.TeamDTO;

import it.contrader.model.Team;


@Service
public class TeamService extends AbstractService<Team,TeamDTO> {

	//ALL crud methods in AbstractService
	
		
	
	public TeamDTO findByName(String name) {
		return converter.toDTO(((TeamRepository)repository).findByName(name));
	}
	
	}

