package it.contrader.view.match;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MatchDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public MatchDeleteView() {
	}


	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			request.put("mode", "MATCHLIST");
			MainDispatcher.getInstance().callAction("Match", "doControl", request);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci id del match:");
			id = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Match", "doControl", request);
	}


}
