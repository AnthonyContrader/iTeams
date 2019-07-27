package it.contrader.view.feedback;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class FeedbackDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public FeedbackDeleteView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			request.put("mode", "FEEDBACKLIST");
			MainDispatcher.getInstance().callAction("Feedback", "doControl", request);
	
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci id del feedback:");
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
