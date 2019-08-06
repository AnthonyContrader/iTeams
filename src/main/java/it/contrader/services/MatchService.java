package it.contrader.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterMatch;
import it.contrader.dao.MatchRepository;
import it.contrader.dto.MatchDTO;
import it.contrader.model.Match;

@Service
public class MatchService {

	private final MatchRepository matchRepository;

	@Autowired
	public MatchService(MatchRepository matchRepository) {
		this.matchRepository = matchRepository;
	}

	public List<MatchDTO> getListaMatchDTO() {
		return ConverterMatch.toListDTO((List<Match>) matchRepository.findAll());
	}

	public MatchDTO getMatchDTOById(Integer id) {
		return ConverterMatch.toDTO(matchRepository.findById(id).get());
	}


	public boolean insertMatch(MatchDTO matchDTO) {
		return matchRepository.save(ConverterMatch.toEntity(matchDTO)) != null;
	}

	public boolean updateMatch(MatchDTO userDTO) {
		return matchRepository.save(ConverterMatch.toEntity(userDTO)) != null;
	}
	
	public void deleteMatchById(Integer id) {
		matchRepository.deleteById(id);
	}
	
	public List<MatchDTO> findMatchDTOByCity(String city) {
		final List<Match> list = matchRepository.findAllByCity(city);
		final List<MatchDTO> matchDTOs = new ArrayList<>();
		list.forEach(i -> matchDTOs.add(ConverterMatch.toDTO(i)));
		return matchDTOs;
	}
	
	public List<MatchDTO> findMatchDTOByDate(Date matchtime) {
		final List<Match> list = matchRepository.findAllByDate(matchtime);
		final List<MatchDTO> matchDTOs = new ArrayList<>();
		list.forEach(i -> matchDTOs.add(ConverterMatch.toDTO(i)));
		return matchDTOs;
	}
}
