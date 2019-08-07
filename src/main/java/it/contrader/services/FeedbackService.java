package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterFeedback;
import it.contrader.converter.ConverterSport;
import it.contrader.dao.FeedbackRepository;
import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.SportDTO;
import it.contrader.model.Feedback;
import it.contrader.model.Sport;

@Service
public class FeedbackService {

	private final FeedbackRepository feedbackRepository;

	@Autowired
	public FeedbackService(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	public List<FeedbackDTO> getListaFeedbackDTO() {
		return ConverterFeedback.toListDTO((List<Feedback>) feedbackRepository.findAll());
	}

	public FeedbackDTO getFeedbackDTOById(Integer id) {
		return ConverterFeedback.toDTO(feedbackRepository.findById(id).get());
	}


	public boolean insertFeedback(FeedbackDTO feedbackDTO) {
		return feedbackRepository.save(ConverterFeedback.toEntity(feedbackDTO)) != null;
	}

	public boolean updateFeedback(FeedbackDTO feedbackDTO) {
		return feedbackRepository.save(ConverterFeedback.toEntity(feedbackDTO)) != null;
	}
	
	public void deleteFeedbackById(Integer id) {
		feedbackRepository.deleteById(id);
	}
	
	public FeedbackDTO getFeedbackDTOByIdSport(Integer id) {
		return ConverterFeedback.toDTO(feedbackRepository.findById(id).get());
	}
	
	public FeedbackDTO getFeedbackDTOByIdUser(Integer id) {
		return ConverterFeedback.toDTO(feedbackRepository.findById(id).get());
	}
	
	public FeedbackDTO getFeedbackDTOByRate(Integer id) {
		return ConverterFeedback.toDTO(feedbackRepository.findById(id).get());
	}
	
	
	}
