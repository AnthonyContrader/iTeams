package it.contrader.view.feedback;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class FeedbackInsertView extends AbstractView{
	private Request request;

	private int idSport;
	private int idUser;
	private int rate;
	private final String mode = "INSERT";

	public FeedbackInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			request.put("mode", "FEEDBACKLIST");
			MainDispatcher.getInstance().callAction("Feedback", "doControl", request);
	
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'utente:");
			idUser = Integer.parseInt(getInput());
			System.out.println("Inserisci id dello sport:");
			idSport = Integer.parseInt(getInput());
			System.out.println("Inserisci il feedback:");
			rate = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("idSport", idSport);
		request.put("idUser", idUser);
		request.put("rate", rate);	
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Feedback", "doControl", request);
	}


}
