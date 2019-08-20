package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
	
	Feedback findById(long id);
}
