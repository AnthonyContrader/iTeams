package it.contrader.controller;

import java.util.List;

import it.contrader.dto.FeedbackDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.FeedbackService;


public class FeedbackController implements Controller {

	private static String sub_package = "feedback.";

	private FeedbackService feedbackService;

	public FeedbackController() {

		this.feedbackService = new FeedbackService();

	}

	@Override
	public void doControl(Request request) {

		String mode = (String) request.get("mode");

		String choice = (String) request.get("choice");

		int id;
		int idSport;
		int idUser;
		int rate;

		

		switch (mode) {

		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			FeedbackDTO feedbackDTO = feedbackService.read(id);
			request.put("feedback", feedbackDTO);
			MainDispatcher.getInstance().callView(sub_package + "FeedbackRead", request);
			break;

		case "INSERT":
			idSport = Integer.parseInt(request.get("idSport").toString());
			idUser = Integer.parseInt(request.get("idUser").toString());
			rate = Integer.parseInt(request.get("rate").toString());
			FeedbackDTO usertoinsert = new FeedbackDTO(idSport, idUser, rate);
			//invoca il service
			feedbackService.insert(usertoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "FeedbackInsert", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			feedbackService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "FeedbackDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			idSport = Integer.parseInt(request.get("idSport").toString());
			idUser = Integer.parseInt(request.get("idUser").toString());
			rate = Integer.parseInt(request.get("rate").toString());
			FeedbackDTO feedbacktoupdate = new FeedbackDTO(idSport, idUser, rate);
			feedbacktoupdate.setId(id);
			feedbackService.update(feedbacktoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "FeedbackUpdate", request);
			break;

		case "FEEDBACKLIST":
			List<FeedbackDTO> feedbacksDTO = feedbackService.getAll();
			// Impacchetta la request con la lista degli user
			request.put("feedback", feedbacksDTO);
			MainDispatcher.getInstance().callView("Feedback", request);
			break;

		case "GETCHOICE":

			// toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_package + "FeedbackRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_package + "FeedbackInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_package + "FeedbackUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_package + "FeedbackDelete", null);
				break;

			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeUser", null);
				break;

			default:
				MainDispatcher.getInstance().callView("Login", null);
			}

		default:
			MainDispatcher.getInstance().callView("Login", null);
		}

	}

}
