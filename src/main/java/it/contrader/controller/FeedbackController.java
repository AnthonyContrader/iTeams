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
@RequestMapping("/feedback")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController extends AbstractController<FeedbackDTO>{
	
	@Autowired
	private FeedbackService feedbackService;


	//POST Angular a UserDTO
	@PostMapping(value = "/read")
	public FeedbackDTO read( @RequestBody FeedbackDTO feedbackDTO ) {
		return feedbackService.findById(feedbackDTO.getId());
	}
	
}
