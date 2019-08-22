package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.model.Team;

import java.util.List;

import javax.transaction.Transactional;


@Repository
@Transactional

public interface TeamRepository extends CrudRepository<Team, Long> {

	Team findByName(String name);
}
