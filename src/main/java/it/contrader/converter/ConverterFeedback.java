package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.EventDTO;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Event;
import it.contrader.model.Feedback;


public class ConverterFeedback {
	
	public static FeedbackDTO toDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO = null;
		if (feedback != null) {
			feedbackDTO = new FeedbackDTO();
			feedbackDTO.setId(feedback.getId());
			feedbackDTO.setIdSport(feedback.getIdSport());
			feedbackDTO.setIdUser(feedback.getIdUser());
			feedbackDTO.setRate(feedback.getRate());
		}
		return feedbackDTO;
	}
	
	public static Feedback toEntity(FeedbackDTO feedbackDTO) {
		Feedback feedback = null; 
		if (feedbackDTO != null) {
			feedback = new Feedback();
			feedback.setId(feedbackDTO.getId());
			feedbackDTO.setIdSport(feedback.getIdSport());
			feedbackDTO.setIdUser(feedback.getIdUser());
			feedbackDTO.setRate(feedback.getRate());
		}
		return feedback;
	}
	public static List<FeedbackDTO> toListDTO(List<Feedback> list) {
		List<FeedbackDTO> listFeedbackDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Feedback feedback : list) {
				listFeedbackDTO.add(ConverterFeedback.toDTO(feedback));
			}
		}
		return listFeedbackDTO;
	}
	
	public static List<Feedback> toListEntity(List<FeedbackDTO> listFeedbackDTO) {
		List<Feedback> list = new ArrayList<>();
		if (!listFeedbackDTO.isEmpty()) {
			for (FeedbackDTO feedbackDTO : listFeedbackDTO) {
				list.add(ConverterFeedback.toEntity(feedbackDTO));
			}
		}
		return list;
	}
}


