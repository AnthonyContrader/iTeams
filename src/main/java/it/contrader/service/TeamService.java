package it.contrader.service;

import it.contrader.dao.TeamRepository;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;

public class TeamService extends AbstractService<Team,TeamDTO>{
	
	//manager method
		public TeamDTO findById(long id) {
			return converter.toDTO(((TeamRepository)repository).findById(id));
		}
	
}
