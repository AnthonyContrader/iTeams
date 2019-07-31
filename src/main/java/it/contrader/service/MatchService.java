package it.contrader.service;

import java.util.List;

import it.contrader.converter.MatchConverter;
import it.contrader.dao.MatchDAO;
import it.contrader.dto.MatchDTO;
import it.contrader.model.Match;

public class MatchService extends AbstractService<Match, MatchDTO> {
	
	public MatchService() {
		this.dao = new MatchDAO();
		this.converter = new MatchConverter();
	}
	
	public List<MatchDTO> getJoined(int id) {
		MatchDAO mDao = (MatchDAO) dao;
		return converter.toDTOList(mDao.getJoined(id));
	}

	public List<MatchDTO> getNotJoined(int id) {
		MatchDAO mDao = (MatchDAO) dao;
		return converter.toDTOList(mDao.getNotJoined(id));
	}
	
	public List<MatchDTO> getMine(int id) {
		MatchDAO mDao = (MatchDAO) dao;
		return converter.toDTOList(mDao.getMine(id));
	}
	
}

