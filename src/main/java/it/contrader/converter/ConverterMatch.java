package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MatchDTO;
import it.contrader.model.Match;

public class ConverterMatch {

	public static MatchDTO toDTO(Match match) {
		MatchDTO matchDTO = null;
		if (match != null) {
			matchDTO = new MatchDTO();
			matchDTO.setId(match.getId());
			matchDTO.setSportName(match.getSportName());
			matchDTO.setUserName(match.getUserName());
			matchDTO.setRate(match.getRate());
			matchDTO.setCity(match.getCity());
			matchDTO.setAddress(match.getAddress());
			matchDTO.setMatchtime(match.getMatchtime());
			matchDTO.setStatus(match.getStatus());
		}
		return matchDTO;
	}

	public static Match toEntity(MatchDTO matchDTO) {
		Match match = null;
		if (matchDTO != null) {
			match = new Match();
			match.setId(matchDTO.getId());
			match.setSportName(matchDTO.getSportName());
			match.setUserName(matchDTO.getUserName());
			match.setRate(matchDTO.getRate());
			match.setCity(matchDTO.getCity());
			match.setAddress(matchDTO.getAddress());
			match.setMatchtime(matchDTO.getMatchtime());
			match.setStatus(matchDTO.getStatus());
		}
		return match;
	}

	public static List<MatchDTO> toListDTO(List<Match> list) {
		List<MatchDTO> listMatchDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Match match : list) {
				listMatchDTO.add(ConverterMatch.toDTO(match));
			}
		}
		return listMatchDTO;
	}

	public static List<Match> toListEntity(List<MatchDTO> listMatchDTO) {
		List<Match> list = new ArrayList<>();
		if (!listMatchDTO.isEmpty()) {
			for (MatchDTO matchDTO : listMatchDTO) {
				list.add(ConverterMatch.toEntity(matchDTO));
			}
		}
		return list;
	}
}
