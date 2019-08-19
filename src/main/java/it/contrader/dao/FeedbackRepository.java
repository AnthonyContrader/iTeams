package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Feedback;
import it.contrader.model.Sport;
import it.contrader.model.User;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
	
	public Feedback findFeedbackBySportAndUserAndRate(Sport sport, User user, Integer rate);
	public List<Feedback> findAllBySport(Sport sport);
	public List<Feedback> findAllByUser(User user);
	public List<Feedback> findAllByRate(Integer Rate);
}