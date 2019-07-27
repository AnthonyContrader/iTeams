package it.contrader.view.match;

import it.contrader.controller.Request;
import it.contrader.dto.MatchDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class MatchReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public MatchReadView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			MatchDTO match = (MatchDTO) request.get("match");
			System.out.println(match);
			request.put("mode", "MATCHLIST");
			MainDispatcher.getInstance().callAction("Match", "doControl", request);
		}
	}

	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del match:");
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