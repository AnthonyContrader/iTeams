package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Feedback;

import java.sql.Date;
import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
	
	public Feedback findFeedbackByIdSportAndIdUserAndRate(Integer idSport, Integer idUser, Integer rate);
	public List<Feedback> findAllByIdSport(Integer idSport);
	public List<Feedback> findAllByIdUser(Integer idUser);
	public List<Feedback> findAllByRate(Integer Rate);
}
