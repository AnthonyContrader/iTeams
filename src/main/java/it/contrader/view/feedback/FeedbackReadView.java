package it.contrader.view.feedback;

import it.contrader.controller.Request;
import it.contrader.dto.FeedbackDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class FeedbackReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public FeedbackReadView() {
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
			FeedbackDTO feedback = (FeedbackDTO) request.get("feedback");
			System.out.println(feedback);
			MainDispatcher.getInstance().callView("Feedback", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id del feedback da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del feedback:");
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
		MainDispatcher.getInstance().callAction("Feedback", "doControl", request);
	}

}
