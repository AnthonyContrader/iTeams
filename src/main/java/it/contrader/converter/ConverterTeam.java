package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;


public class ConverterTeam {
	
	public static TeamDTO toDTO(Team team) {
		TeamDTO teamDTO = null;
		if (team != null) {
			teamDTO = new TeamDTO();
			teamDTO.setId(team.getId());
			teamDTO.setName(team.getName());
//			teamDTO.setIdSport(team.getIdSport());
//			teamDTO.setPlayers(team.getPlayers());
			teamDTO.setEventDTO(ConverterEvent.toDTO(team.getEvent()));
			teamDTO.setComponentsDTO(ConverterUser.toSetDTO(team.getComponents()));
		}
		return teamDTO;
		
	}
	
	public static Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO !=null) {
			team = new Team ();
			team.setId(teamDTO.getId());
			team.setName(teamDTO.getName());
//			team.setIdSport(teamDTO.getIdSport());
//			team.setPlayers(teamDTO.getPlayers());
			team.setEvent(ConverterEvent.toEntity(teamDTO.getEventDTO()));
			team.setComponents(ConverterUser.toSetEntity(teamDTO.getComponentsDTO()));
						
		}
		return team;
			
	}
	
	public static List<TeamDTO> toListDTO(List<Team> list) {
		List <TeamDTO> listTeamDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Team team : list) {
				listTeamDTO.add(ConverterTeam.toDTO(team));
			}
		}
		return listTeamDTO;
				
		
	}
	

	public static List<Team> toListEntity(List<TeamDTO> listTeamDTO) {
		List<Team> list = new ArrayList<>();
		if (!listTeamDTO.isEmpty()) {
			for (TeamDTO teamDTO : listTeamDTO) {
				
				list.add(ConverterTeam.toEntity(teamDTO));
			}
		}
		return list;
	}
	
	public static Set<TeamDTO> toSetDTO(Set<Team> set) {
		Set<TeamDTO> setTeamDTO = new HashSet<>();
		if (!set.isEmpty()) {
			for (Team team : set) {
				setTeamDTO.add(ConverterTeam.toDTO(team));
			}
		}
		return setTeamDTO;
	}
	
	public static Set<Team> toSetEntity(Set<TeamDTO> setTeamDTO) {
		Set<Team> set = new HashSet<>();
		if (!setTeamDTO.isEmpty()) {
			for (TeamDTO teamDTO : setTeamDTO) {
				set.add(ConverterTeam.toEntity(teamDTO));
			}
		}
		return set;
	}

	
}
	



	