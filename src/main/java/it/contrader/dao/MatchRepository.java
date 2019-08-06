package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Match;

import java.util.Date;
import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Integer> {
	
	public Match findMatchByCityAndAddressAndDate(String username,String password);
	public List<Match> findAllByCityAndDate(String city,Date matchtime);
	public List<Match> findAllByDate(Date matchtime);
	public List<Match> findAllByCity(String city);

}
