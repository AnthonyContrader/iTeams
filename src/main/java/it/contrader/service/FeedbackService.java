package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.FeedbackRepository;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

@Service
public class FeedbackService extends AbstractService<Feedback,FeedbackDTO>{
	
	public FeedbackDTO findById(long id) {
		return converter.toDTO(((FeedbackRepository)repository).findById(id));
	}
}
