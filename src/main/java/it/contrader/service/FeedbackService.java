package it.contrader.service;

import it.contrader.model.Feedback;

import org.springframework.stereotype.Service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.FeedbackRepository;
import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.UserDTO;

@Service
public class FeedbackService extends AbstractService<Feedback, FeedbackDTO> {
	
	public FeedbackDTO findByUserAndSportName(UserDTO user, String sportName) {
		return converter.toDTO(((FeedbackRepository)repository).findByUserAndSportName(user, sportName));
	}

	public Iterable<FeedbackDTO> getMine(UserDTO userDTO) {
		UserConverter uc = new UserConverter();
		return converter.toDTOList(((FeedbackRepository)repository).getAllByUser(uc.toEntityS(userDTO)));
	}
	
	
	
}
