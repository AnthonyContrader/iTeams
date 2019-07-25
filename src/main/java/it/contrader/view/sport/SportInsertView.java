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
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			//MainDispatcher.getInstance().callView("Sport", null);
			request.put("mode", "SPORTLIST");
			MainDispatcher.getInstance().callAction("Sport", "doControl", request);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome dello sport:");
			name = getInput();
			System.out.println("Inserisci numero di giocatori:");
			players = Integer.parseInt(getInput());
			
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("players", players);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Sport", "doControl", request);
	}


}
