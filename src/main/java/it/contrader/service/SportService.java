package it.contrader.service;

import java.util.List;

import it.contrader.converter.SportConverter;
import it.contrader.dao.MatchDAO;
import it.contrader.dao.SportDAO;
import it.contrader.dto.MatchDTO;
import it.contrader.dto.SportDTO;
import it.contrader.model.Sport;

public class SportService extends AbstractService<Sport, SportDTO>{
	public SportService() {
		this.dao = new SportDAO();
		this.converter = new SportConverter();
	}
	
	public List<SportDTO> getJoined(int id) {
		SportDAO sDao = (SportDAO) dao;
		return converter.toDTOList(sDao.getJoined(id));
	}

	public List<SportDTO> getNotJoined(int id) {
		SportDAO sDao = (SportDAO) dao;
		return converter.toDTOList(sDao.getNotJoined(id));
	}
	
}