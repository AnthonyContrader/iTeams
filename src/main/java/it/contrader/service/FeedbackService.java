package it.contrader.service;

import it.contrader.dao.FeedbackRepository;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

public class FeedbackService extends AbstractService<Feedback,FeedbackDTO>{
	
	public FeedbackDTO findById(long id) {
		return converter.toDTO(((FeedbackRepository)repository).findById(id));
	}
}
