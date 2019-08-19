package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import it.contrader.model.Team;
import java.util.List;


public interface TeamRepository extends CrudRepository<Team, Integer> {

	public Team findTeamByName(String name);
	public List<Team> findAllByName(String name);
	//public List<Team> findAllByPlayers(Integer players);
}
