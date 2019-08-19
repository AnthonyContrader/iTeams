package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;


public class ConverterFeedback {
	
	public static FeedbackDTO toDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO = null;
		if (feedback != null) {
			feedbackDTO = new FeedbackDTO();
			feedbackDTO.setId(feedback.getId());
			feedbackDTO.setSportDTO(ConverterSport.toDTO(feedback.getSport()));
			feedbackDTO.setUserDTO(ConverterUser.toDTO(feedback.getUser()));
			feedbackDTO.setCreatorDTO(ConverterUser.toDTO(feedback.getCreator()));
			feedbackDTO.setRate(feedback.getRate());
		}
		return feedbackDTO;
	}
	
	public static Feedback toEntity(FeedbackDTO feedbackDTO) {
		Feedback feedback = null; 
		if (feedbackDTO != null) {
			feedback = new Feedback();
			feedback.setId(feedbackDTO.getId());
			feedback.setSport(ConverterSport.toEntity(feedbackDTO.getSportDTO()));
			feedback.setUser(ConverterUser.toEntity(feedbackDTO.getUserDTO()));
			feedback.setCreator(ConverterUser.toEntity(feedbackDTO.getCreatorDTO()));
			feedback.setRate(feedbackDTO.getRate());
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
	
	public static Set<FeedbackDTO> toSetDTO(Set<Feedback> set) {
		Set<FeedbackDTO> setFeedbackDTO = new HashSet<>();
		if (!set.isEmpty()) {
			for (Feedback feedback : set) {
				setFeedbackDTO.add(ConverterFeedback.toDTO(feedback));
			}
		}
		return setFeedbackDTO;
	}
	
	public static Set<Feedback> toSetEntity(Set<FeedbackDTO> setFeedbackDTO) {
		Set<Feedback> set = new HashSet<>();
		if (!setFeedbackDTO.isEmpty()) {
			for (FeedbackDTO feedbackDTO : setFeedbackDTO) {
				set.add(ConverterFeedback.toEntity(feedbackDTO));
			}
		}
		return set;
	}
}


