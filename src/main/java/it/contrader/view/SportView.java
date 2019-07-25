package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SportDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class SportView extends AbstractView {

	private Request request;
	private String choice;

	public SportView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione s ----------------\n");
			System.out.println("ID\tPlayers\tName");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<SportDTO> sports = (List<SportDTO>) request.get("sport");
			for (SportDTO m: sports)
				System.out.println(m);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Sport", "doControl", this.request);
	}

}