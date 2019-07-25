package it.contrader.service;

import it.contrader.converter.SportConverter;
import it.contrader.dao.SportDAO;
import it.contrader.dto.SportDTO;
import it.contrader.model.Sport;

public class SportService extends AbstractService<Sport, SportDTO>{
	
	public SportService(){
		this.dao = new SportDAO();
		this.converter = new SportConverter();
	}
	

}