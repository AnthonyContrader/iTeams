package it.contrader.view.sport;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SportDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public SportDeleteView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			request.put("mode", "SPORTLIST");
			MainDispatcher.getInstance().callAction("Sport", "doControl", request);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci id dello sport:");
			id = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Sport", "doControl", request);
	}


}