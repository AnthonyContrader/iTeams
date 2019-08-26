package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.FeedbackService;


@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController extends AbstractController<FeedbackDTO>{
	
	@Autowired
	private FeedbackService feedbackService;
	
	
	/*@PostMapping(value = "/feedbackmanager")
	public FeedbackDTO sportmanager( @RequestBody FeedbackDTO feedbackDTO ) {
		return feedbackService.findByUserAndSportName(feedbackDTO.getUser(), feedbackDTO.getSportName());
	}
	
	@PostMapping("/getmine")
	public Iterable<FeedbackDTO> getMine(UserDTO user){
		return feedbackService.getMine(user);		
	}	*/
}
