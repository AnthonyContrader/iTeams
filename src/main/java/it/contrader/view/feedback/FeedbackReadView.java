package it.contrader.view.feedback;

import it.contrader.controller.Request;
import it.contrader.dto.FeedbackDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class FeedbackReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public FeedbackReadView() {
	}


	@Override
	public void showResults(Request request) {
		if (request != null) {
			FeedbackDTO feedback = (FeedbackDTO) request.get("feedback");
			System.out.println(feedback);
			request.put("mode", "FEEDBACKLIST");
			MainDispatcher.getInstance().callAction("Feedback", "doControl", request);
		}
	}

	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del feedback:");
		id = Integer.parseInt(getInput());
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Feedback", "doControl", request);
	}

}
