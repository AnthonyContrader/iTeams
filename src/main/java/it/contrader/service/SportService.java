package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.SportConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.SportRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Sport;
import it.contrader.model.User;

@Service
public class SportService extends AbstractService<Sport,SportDTO> {

	//ALL crud methods in AbstractService
	
		//sportmanager method
	
	public SportDTO findByName(String name) {
		return converter.toDTO(((SportRepository)repository).findByName(name));
	}
	
	}

