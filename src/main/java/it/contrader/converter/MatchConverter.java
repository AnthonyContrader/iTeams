package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.MatchDTO;
import it.contrader.model.Match;

public class MatchConverter implements Converter<Match, MatchDTO>{

	
	public MatchDTO toDTO(Match match) {
		MatchDTO matchDTO =new MatchDTO(match.getId(), match.getIdSport(), match.getIdUser(), match.getRate(), match.getAddress(), match.getMatchtime() );
		return matchDTO;
	}

	
	public Match toEntity(MatchDTO matchDTO) {
		Match match =new Match(matchDTO.getId(), matchDTO.getIdSport(),matchDTO.getIdUser(),matchDTO.getRate(),matchDTO.getAddress(),matchDTO.getMatchtime());
			return match;
	}

	public List<MatchDTO> toDTOList(List<Match> matchList) {
		List<MatchDTO> matchDTOList = new ArrayList<MatchDTO>();
		
		for(Match match: matchList) {
			matchDTOList.add(toDTO(match));
		}
		
		return matchDTOList;
	}
	
}
