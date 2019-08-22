package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import it.contrader.dto.SportDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Sport;
import it.contrader.model.Team;


@Component
public class TeamConverter extends AbstractConverter<Team,TeamDTO> { 
	
	
	
	@Override
	public TeamDTO toDTO(Team team) {
		TeamDTO teamDTO = null;
		if (team != null) {
			teamDTO = new TeamDTO();
			teamDTO.setId(team.getId());
			teamDTO.setName(team.getName());

		}
		return teamDTO;
		
	}
	
	@Override
	public Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO !=null) {
			team = new Team ();
			team.setId(teamDTO.getId());
			team.setName(teamDTO.getName());

						
		}
		return team;
			
	}
}