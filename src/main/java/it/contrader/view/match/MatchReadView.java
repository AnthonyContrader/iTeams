package it.contrader.view.match;

import it.contrader.controller.Request;
import it.contrader.dto.MatchDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class MatchReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public MatchReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			MatchDTO match = (MatchDTO) request.get("match");
			System.out.println(match);
			MainDispatcher.getInstance().callView("Match", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id del match da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del match:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Match", "doControl", request);
	}

}
