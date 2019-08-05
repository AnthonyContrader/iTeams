package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterSport;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.SportRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Sport;
import it.contrader.model.User;

@Service
public class SportService {

	private final SportRepository sportRepository;

	@Autowired
	public SportService(SportRepository sportRepository) {
		this.sportRepository = sportRepository;
	}

	public List<SportDTO> getListaSportDTO() {
		return ConverterSport.toListDTO((List<Sport>) sportRepository.findAll());
	}

	public SportDTO getSportDTOById(Integer id) {
		return ConverterSport.toDTO(sportRepository.findById(id).get());
	}

	public SportDTO getSportDTOByPlayers(Integer id) {
		return ConverterSport.toDTO(sportRepository.findById(id).get());
	}

	public SportDTO getByName(String name) {

		final Sport sport = sportRepository.findSportByName(name);

		return ConverterSport.toDTO(sport);
	}

	public boolean insertSport(SportDTO sportDTO) {
		return sportRepository.save(ConverterSport.toEntity(sportDTO)) != null;
	}

	public boolean updateSport(SportDTO sportDTO) {
		return sportRepository.save(ConverterSport.toEntity(sportDTO)) != null;
	}
	
	public void deleteSportById(Integer idSport) {
		sportRepository.deleteById(idSport);
	}
	
	public List<SportDTO> findSportDTOByName(String name) {
		
		final List<Sport> list = sportRepository.findAll(name);
		final List<SportDTO> sportDTOs = new ArrayList<>();
		list.forEach(i -> sportDTOs.add(ConverterSport.toDTO(i)));
		return sportDTOs;
		
	
	}
}

