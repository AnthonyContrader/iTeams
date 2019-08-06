package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Match;

import java.sql.Date;
import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Integer> {
	
	public Match findMatchByCityAndAddressAndMatchtime(String city,String address, String matchtime);
	public List<Match> findAllByCityAndMatchtime(String city,String matchtime);
	public List<Match> findAllByMatchtime(String matchtime);
	public List<Match> findAllByCity(String city);

}