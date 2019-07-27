package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SportDTO;
import it.contrader.main.MainDispatcher;



public class SportView extends AbstractView {

	private Request request;
	private String choice;

	public SportView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n--------------- Gestione Sport ---------------\n");
			System.out.println("ID\t\tPlayers\t\tName");
			System.out.println("----------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<SportDTO> sports = (List<SportDTO>) request.get("sport");
			for (SportDTO m: sports)
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
		MainDispatcher.getInstance().callAction("Sport", "doControl", this.request);
	}

}