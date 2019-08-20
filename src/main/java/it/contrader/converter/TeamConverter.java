package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;

@Component
public class TeamConverter extends AbstractConverter<Team, TeamDTO> {
	
	public TeamDTO toDTO(Team team) {
		TeamDTO teamDTO = null;
		if (team != null) {
			teamDTO = new TeamDTO();
			teamDTO.setId(team.getId());
			teamDTO.setName(team.getName());
			teamDTO.setEventDTO(ConverterEvent.toDTO(team.getEvent()));
			//teamDTO.setComponentsDTO(ConverterUser.toSetDTO(team.getComponents()));
		}
		return teamDTO;
		
	}
	
	public Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO !=null) {
			team = new Team ();
			team.setId(teamDTO.getId());
			team.setName(teamDTO.getName());
			team.setEvent(ConverterEvent.toEntity(teamDTO.getEventDTO()));
			//team.setComponents(ConverterUser.toSetEntity(teamDTO.getComponentsDTO()));
						
		}
		return team;
			
	}
}