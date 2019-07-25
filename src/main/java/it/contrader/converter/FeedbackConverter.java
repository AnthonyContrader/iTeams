package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

public class FeedbackConverter implements Converter<Feedback, FeedbackDTO>{

	
	public FeedbackDTO toDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO =new FeedbackDTO(feedback.getId(), feedback.getIdSport(), feedback.getIdUser(), feedback.getRate());
		return feedbackDTO;
	}

	
	public Feedback toEntity(FeedbackDTO feedbackDTO) {
		Feedback feedback =new Feedback(feedbackDTO.getId(), feedbackDTO.getIdSport(),feedbackDTO.getIdUser(),feedbackDTO.getRate());
			return feedback;
	}

	public List<FeedbackDTO> toDTOList(List<Feedback> feedbackList) {
		List<FeedbackDTO> feedbackDTOList = new ArrayList<FeedbackDTO>();
		
		for(Feedback feedback: feedbackList) {
			feedbackDTOList.add(toDTO(feedback));
		}
		
		return feedbackDTOList;
	}
	
}
