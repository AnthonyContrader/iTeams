package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.MatchDTO;
import it.contrader.main.MainDispatcher;


public class MatchView extends AbstractView {

	private Request request;
	private String choice;

	public MatchView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------------------------------- Gestione match -------------------------------------------\n");
			System.out.println("ID\tID Sport\tID User\t\tRate\t\tMatchtime\t\t\tAddress");
			System.out.println("------------------------------------------------------------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<MatchDTO> matchs = (List<MatchDTO>) request.get("match");
			for (MatchDTO m: matchs)
				System.out.println(m);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Match", "doControl", this.request);
	}

}