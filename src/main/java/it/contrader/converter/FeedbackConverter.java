package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

@Component
public class FeedbackConverter extends AbstractConverter<Feedback, FeedbackDTO> {
	
	@Override
	public FeedbackDTO toDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO = null;
		if (feedback != null) {
			feedbackDTO = new FeedbackDTO();
			feedbackDTO.setId(feedback.getId());
			feedbackDTO.setSportName(feedback.getSportName());
			feedbackDTO.setUserName(feedback.getUserName());
			feedbackDTO.setCreatorName(feedback.getCreatorName());
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
			feedback.setSportName(feedbackDTO.getSportName());
			feedback.setUserName(feedbackDTO.getUserName());
			feedback.setCreatorName(feedbackDTO.getCreatorName());
			feedback.setRate(feedbackDTO.getRate());
		}
		return feedback;
	}
}
