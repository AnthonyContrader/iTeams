package it.contrader.service;

import it.contrader.model.Feedback;
import org.springframework.stereotype.Service;
import it.contrader.dao.FeedbackRepository;
import it.contrader.dto.FeedbackDTO;

@Service
public class FeedbackService extends AbstractService<Feedback, FeedbackDTO> {
	
	public FeedbackDTO findByUserNameAndSportName(String userName, String sportName) {
		return converter.toDTO(((FeedbackRepository)repository).findByUserNameAndSportName(userName, sportName));
	}	
}
