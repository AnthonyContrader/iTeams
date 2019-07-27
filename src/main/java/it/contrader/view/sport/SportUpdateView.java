package it.contrader.view.sport;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class SportUpdateView extends AbstractView {
	private Request request;

	private int id;
	private int players;
	private String name;
	

	private final String mode = "UPDATE";

	public SportUpdateView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			request.put("mode", "SPORTLIST");
			MainDispatcher.getInstance().callAction("Sport", "doControl", request);
		}
	}

	
	@Override
	public void showOptions() {
		try {
			
			System.out.println("Inserisci id del sport da aggiornare:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci numero di giocatori:");
			players = Integer.parseInt(getInput());			
			System.out.println("Inserisci nome dello sport:");
			name = getInput();
			
			
		} catch (Exception e) {

		}
	}


	@Override
	public void submit() {
				
		request = new Request();
		request.put("id", id);
		request.put("players", players);		
		request.put("name", name);				
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Sport", "doControl", request);
		
	}

}