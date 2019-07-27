package it.contrader.service;

import it.contrader.converter.FeedbackConverter;
import it.contrader.dao.FeedbackDAO;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

public class FeedbackService extends AbstractService<Feedback, FeedbackDTO>{
	
	public FeedbackService(){
		this.dao = new FeedbackDAO();
		this.converter = new FeedbackConverter();
	}
	

}