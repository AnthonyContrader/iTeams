package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.FeedbackDTO;
import it.contrader.service.FeedbackService;


@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController extends AbstractController<FeedbackDTO>{
	
	@Autowired
	private FeedbackService feedbackService;
	
	
	@PostMapping(value = "/feedbackmanager")
	public FeedbackDTO sportmanager( @RequestBody FeedbackDTO feedbackDTO ) {
		return feedbackService.findByUserNameAndSportName(feedbackDTO.getUserName(), feedbackDTO.getSportName());
	}
	
}
