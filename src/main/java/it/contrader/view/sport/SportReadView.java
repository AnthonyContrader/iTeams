package it.contrader.view.sport;

import it.contrader.controller.Request;
import it.contrader.dto.SportDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class SportReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public SportReadView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			SportDTO sport = (SportDTO) request.get("sport");
			System.out.println(sport);
			request.put("mode", "SPORTLIST");
			MainDispatcher.getInstance().callAction("Sport", "doControl", request);
		}
	}

	
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'id dello sport:");
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