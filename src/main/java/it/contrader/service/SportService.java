package it.contrader.service;

import org.springframework.stereotype.Service;
import it.contrader.dao.SportRepository;
import it.contrader.dto.SportDTO;
import it.contrader.model.Sport;

@Service
public class SportService extends AbstractService<Sport,SportDTO> {

	//ALL crud methods in AbstractService
	
		//sportmanager method
	
	public SportDTO findByName(String name) {
		return converter.toDTO(((SportRepository)repository).findByName(name));
	}
	
	}

