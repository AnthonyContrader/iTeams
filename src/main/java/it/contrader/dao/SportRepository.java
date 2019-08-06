package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.model.Sport;

import java.util.List;

import javax.transaction.Transactional;

public interface SportRepository extends CrudRepository<Sport, Integer> {

	public Sport findSportByName(String name);
	public List<Sport> findAllByName(String name);
	public List<Sport> findAllByPlayers(Integer players);
}
