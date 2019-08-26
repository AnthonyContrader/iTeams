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
			UserConverter userC = new UserConverter();
			feedbackDTO.setUser(userC.toDTOS(feedback.getUser()));
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
			UserConverter userC = new UserConverter();
			feedback.setUser(userC.toEntityS(feedbackDTO.getUser()));
			feedback.setCreatorName(feedbackDTO.getCreatorName());
			feedback.setRate(feedbackDTO.getRate());
		}
		return feedback;
	}

	@Override
	public FeedbackDTO toDTOS(Feedback feedback) {
		FeedbackDTO feedbackDTO = null;
		if (feedback != null) {
			feedbackDTO = new FeedbackDTO();
			feedbackDTO.setId(feedback.getId());
			feedbackDTO.setSportName(feedback.getSportName());
			feedbackDTO.setCreatorName(feedback.getCreatorName());
			UserConverter userC = new UserConverter();
			feedbackDTO.setUser(userC.toDTOS(feedback.getUser()));
			feedbackDTO.setRate(feedback.getRate());
		}
		return feedbackDTO;
	}
	
	@Override
	public Feedback toEntityS(FeedbackDTO feedbackDTO) {
		Feedback feedback = null; 
		if (feedbackDTO != null) {
			feedback = new Feedback();
			feedback.setId(feedbackDTO.getId());
			feedback.setSportName(feedbackDTO.getSportName());
			feedback.setCreatorName(feedbackDTO.getCreatorName());
			UserConverter userC = new UserConverter();
			feedback.setUser(userC.toEntityS(feedbackDTO.getUser()));
			feedback.setRate(feedbackDTO.getRate());
		}
		return feedback;
	}
}
