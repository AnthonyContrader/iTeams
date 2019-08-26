package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.dto.UserDTO;
import it.contrader.model.Feedback;
import it.contrader.model.User;

@Repository
@Transactional

public interface FeedbackRepository extends CrudRepository<Feedback, Long>{

	Feedback findByUserAndSportName(UserDTO user, String sportName);

	Iterable<Feedback> getAllByUser(User user);
	
}
