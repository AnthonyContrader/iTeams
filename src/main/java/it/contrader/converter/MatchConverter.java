package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.MatchDTO;
import it.contrader.model.Match;


public class MatchConverter  implements Converter<Match, MatchDTO> {

	public MatchDTO toDTO(Match match) {
		MatchDTO matchDTO = new MatchDTO (match.getId(), match.getIdSport(), match.getIdUser(), match.getRate(), match.getAddress(), match.getMatchtime(), match.isStatus());
		return matchDTO; 
	}

	@Override
	public Match toEntity(MatchDTO matchDTO) {
		Match match =new Match(matchDTO.getId(), matchDTO.getIdSport(), matchDTO.getIdUser(), matchDTO.getRate(), matchDTO.getAddress(), matchDTO.getMatchtime(),matchDTO.isStatus());
		return match;
		
	}
	
	@Override
	public List<MatchDTO> toDTOList(List<Match> matchList) {
		// TODO Auto-generated method stub
		List<MatchDTO> matchDTOList = new ArrayList<MatchDTO>();
		
		for(Match match : matchList) {
		matchDTOList.add(toDTO(match));
		
		
	
		}
		return matchDTOList;
	}
	
	
}

