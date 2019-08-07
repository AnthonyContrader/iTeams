package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.ConverterTeam;
import it.contrader.dao.TeamRepository;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;

@Service
public class TeamService {

	private final TeamRepository teamRepository;

	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	public List<TeamDTO> getListaTeamDTO() {
		return ConverterTeam.toListDTO((List<Team>) teamRepository.findAll());
	}

	public TeamDTO getTeamDTOById(Integer id) {
		return ConverterTeam.toDTO(teamRepository.findById(id).get());
	}

	public TeamDTO getTeamDTOByPlayers(Integer id) {
		return ConverterTeam.toDTO(teamRepository.findById(id).get());
	}

	public TeamDTO getByName(String name) {

		final Team team = teamRepository.findTeamByName(name);

		return ConverterTeam.toDTO(team);
	}

	public boolean insertTeam(TeamDTO teamDTO) {
		return teamRepository.save(ConverterTeam.toEntity(teamDTO)) != null;
	}

	public boolean updateTeam(TeamDTO teamDTO) {
		return teamRepository.save(ConverterTeam.toEntity(teamDTO)) != null;
	}
	
	public void deleteTeamById(Integer idTeam) {
		teamRepository.deleteById(idTeam);
	}
	
	public List<TeamDTO> findTeamDTOByName(String name) {
		
		final List<Team> list = teamRepository.findAllByName(name);
		final List<TeamDTO> teamDTOs = new ArrayList<>();
		list.forEach(i -> teamDTOs.add(ConverterTeam.toDTO(i)));
		return teamDTOs;
		
	
	}
}

