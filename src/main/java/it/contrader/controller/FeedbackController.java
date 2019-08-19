package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.FeedbackService;
import it.contrader.services.SportService;
import it.contrader.services.UserService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/Feedback")

public class FeedbackController {

	private final FeedbackService feedbackService;
	private final UserService userService;
	private final SportService sportService;
	private HttpSession session;

	@Autowired
	public FeedbackController(FeedbackService feedbackService, UserService userService, SportService sportService) {
		this.feedbackService = feedbackService;	
		this.sportService = sportService;
		this.userService = userService;
	}
	
	
	
	@RequestMapping(value = "/feedbackmanager", method = RequestMethod.GET)
	public String feedbackmanager(HttpServletRequest request) {
		visualFeedback(request);
		visualSport(request);
		visualUser(request);
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
	public void visualFeedback(HttpServletRequest request) {
		List<FeedbackDTO> allFeedback= this.feedbackService.getListaFeedbackDTO();
		request.setAttribute("allFeedbackDTO", allFeedback);
	}
	
	private void visualSport(HttpServletRequest request){
		List<SportDTO> allSport= this.sportService.getListaSportDTO();
		request.setAttribute("allSportDTO", allSport);
	}
	
	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser= this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
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
			
		//final FeedbackDTO feedback = new FeedbackDTO(idUpdate, idSportUpdate,  idUserUpdate, rateUpdate);
		final FeedbackDTO feedback = new FeedbackDTO();
		feedback.setId(idUpdate);
		SportDTO sd = new SportDTO();
		sd.setId(idSportUpdate);
		feedback.setSportDTO(sd);
		UserDTO ud = new UserDTO();
		ud.setId(idUserUpdate);
		feedback.setUserDTO(ud);
		UserDTO creatorDTO= (UserDTO) session.getAttribute("utenteCollegato");
		feedback.setCreatorDTO(creatorDTO);
		feedback.setRate(rateUpdate);
		
		feedbackService.updateFeedback(feedback);
		request.setAttribute("feedback", getFeedback());
		return "feedback/feedbackmanager";	
		
	}
	
	
	@RequestMapping(value = "/insertfeedback", method = RequestMethod.POST)
	public String insertFeedback(HttpServletRequest request) {
		
		//Integer id= Integer.parseInt(request.getParameter("id"));
		Integer rate= Integer.parseInt(request.getParameter("rate"));
		Integer idSport= Integer.parseInt(request.getParameter("idsport"));
		Integer idUser= Integer.parseInt(request.getParameter("iduser"));
		Integer idCreator= Integer.parseInt(request.getParameter("creator"));
		
		//FeedbackDTO feedbackDTO = new FeedbackDTO (id, idSport, idUser, rate);
		final FeedbackDTO feedback = new FeedbackDTO();
		//feedback.setId(id);
		SportDTO sd = sportService.getSportDTOById(idSport);
		//sd.setId(idSport);
		feedback.setSportDTO(sd);
		UserDTO ud = userService.getUserDTOById(idUser);
		//ud.setId(idUser);
		feedback.setUserDTO(ud);
		//UserDTO creatorDTO= (UserDTO) session.getAttribute("utenteCollegato");
		UserDTO creatorDTO= userService.getUserDTOById(idCreator);
		feedback.setCreatorDTO(creatorDTO);
		feedback.setRate(rate);
		
		
		feedbackService.insertFeedback(feedback);
		
		visualFeedback(request);
		visualSport(request);
		visualUser(request);
		
		return "/feedback/feedbackmanager";
	}
}