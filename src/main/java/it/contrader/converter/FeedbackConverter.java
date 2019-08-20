package it.contrader.converter;

import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

public class FeedbackConverter extends AbstractConverter <Feedback, FeedbackDTO>{
	
	@Override
	public FeedbackDTO toDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO = null;
		if (feedback != null) {
			feedbackDTO = new FeedbackDTO();
			feedbackDTO.setId(feedback.getId());
//			feedbackDTO.setSportDTO(ConverterSport.toDTO(feedback.getSport()));
//			feedbackDTO.setUserDTO(ConverterUser.toDTO(feedback.getUser()));
//			feedbackDTO.setCreatorDTO(ConverterUser.toDTO(feedback.getCreator()));
			feedbackDTO.setRate(feedback.getRate());
		}
		return feedbackDTO;
	}
	
	@Override
	public Feedback toEntity(FeedbackDTO feedbackDTO) {
		Feedback feedback = null; 
		if (feedbackDTO != null) {
			feedback = new Feedback();
			feedback.setId(feedbackDTO.getId());
//			feedback.setSport(ConverterSport.toEntity(feedbackDTO.getSportDTO()));
//			feedback.setUser(ConverterUser.toEntity(feedbackDTO.getUserDTO()));
//			feedback.setCreator(ConverterUser.toEntity(feedbackDTO.getCreatorDTO()));
			feedback.setRate(feedbackDTO.getRate());
		}
		return feedback;
	}
	
}
