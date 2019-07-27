package it.contrader.service;

import it.contrader.converter.MatchConverter;
import it.contrader.dao.MatchDAO;
import it.contrader.dto.MatchDTO;
import it.contrader.model.Match;

public class MatchService extends AbstractService<Match, MatchDTO>{
	
	public MatchService(){
		this.dao = new MatchDAO();
		this.converter = new MatchConverter();
	}
	

}