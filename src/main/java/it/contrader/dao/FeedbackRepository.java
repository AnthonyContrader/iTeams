package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Feedback;

@Repository
@Transactional

public interface FeedbackRepository extends CrudRepository<Feedback, Long>{

	Feedback findByIdUser(long id);

	Feedback findByIdUserAndIdSport(long idUser, long idSport);

	Feedback findByUserNameAndSportName(String userName, String sportName);
	
}
