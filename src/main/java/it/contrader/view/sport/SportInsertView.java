package it.contrader.view.sport;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SportInsertView extends AbstractView{
	private Request request;

	private int players;
	private String name;	
	private final String mode = "INSERT";

	public SportInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			request.put("mode", "SPORTLIST");
			MainDispatcher.getInstance().callAction("Sport", "doControl", request);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci nome dello sport:");
			name = getInput();
			System.out.println("Inserisci numero di giocatori:");
			players = Integer.parseInt(getInput());
			
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("players", players);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Sport", "doControl", request);
	}


}