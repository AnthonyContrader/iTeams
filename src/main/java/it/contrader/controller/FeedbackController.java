package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import it.contrader.dto.EventDTO;
import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.FeedbackService;
import it.contrader.services.UserService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Feedback")

public class FeedbackController {

	private final FeedbackService feedbackService;
	private HttpSession session;

	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;	
	}
	
	
	
	@RequestMapping(value = "/feedbackmanager", method = RequestMethod.GET)
	public String feedbackmanager(HttpServletRequest request) {
		request.setAttribute("feedback", getFeedback());
		return "/feedback/feedbackmanager";
	}

	public List<FeedbackDTO> getFeedback() {
		List<FeedbackDTO> tmp = feedbackService.getListaFeedbackDTO();
		List<FeedbackDTO> feedbackList = new ArrayList<>();
		for (FeedbackDTO feedback : tmp) {
			
			feedbackList.add(feedback);
			
		}

		return feedbackList;
	}		
	
	@RequestMapping(value ="/deleteFeedback", method = RequestMethod.GET)
	public String deleteFeedback(HttpServletRequest request) {
		int idFeedback = Integer.parseInt(request.getParameter("id"));
		feedbackService.deleteFeedbackById(idFeedback);
		request.setAttribute("feedback", getFeedback());
		return "feedback/feedbackmanager";
	}
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idFeedback = Integer.parseInt(request.getParameter("id"));
		FeedbackDTO feedback = feedbackService.getFeedbackDTOById(idFeedback);
		request.setAttribute("feedback", feedback);
		return "feedback/updatefeedback";
	}
	
	@RequestMapping(value = "/updatefeedback", method = RequestMethod.POST)
	public String updateFeedback(HttpServletRequest request)
	{
		int idUpdate = Integer.parseInt(request.getParameter("id"));
				
		Integer idSportUpdate = Integer.parseInt(request.getParameter("idSport"));
		Integer idUserUpdate = Integer.parseInt(request.getParameter("idUser"));
		Integer rateUpdate = Integer.parseInt(request.getParameter("rate"));
			
		final FeedbackDTO feedback = new FeedbackDTO(idUpdate, idSportUpdate,  idUserUpdate, rateUpdate);
		feedback.setId(idUpdate);
		
		feedbackService.updateFeedback(feedback);
		request.setAttribute("feedback", getFeedback());
		return "feedback/feedbackmanager";	
		
	}
	
	
	@RequestMapping(value = "/insertfeedback", method = RequestMethod.POST)
	public String insertFeedback(HttpServletRequest request) {
		
		Integer id= Integer.parseInt(request.getParameter("id"));
		Integer rate= Integer.parseInt(request.getParameter("rate"));
		Integer idSport= Integer.parseInt(request.getParameter("idSport"));
		Integer idUser= Integer.parseInt(request.getParameter("idUser"));
		
		FeedbackDTO feedbackDTO = new FeedbackDTO (id, idSport, idUser, rate);
		
		feedbackService.insertFeedback(feedbackDTO);
		
		request.setAttribute("feedback", getFeedback());
		
		return "feedback/feedbackmanager";		
	}
	
	@RequestMapping(value= "/readfeedback", method = RequestMethod.GET)
	public String readFeedbackById(HttpServletRequest request) {

	Integer idFeedback= Integer.parseInt( request.getSession().getAttribute("id").toString());
	FeedbackDTO feedback = feedbackService.getFeedbackDTOByIdUser(idFeedback);
	request.setAttribute("feedbackById", feedback);
	
	return "/feedback/readfeedback"; 
	}
	
	
	
}