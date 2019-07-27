package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.FeedbackDTO;
import it.contrader.main.MainDispatcher;


public class FeedbackView extends AbstractView {

	private Request request;
	private String choice;

	public FeedbackView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------ Gestione feedback ---------------\n");
			System.out.println("ID\tID USER\t\tID SPORT\tRate");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<FeedbackDTO> feedbacks = (List<FeedbackDTO>) request.get("feedback");
			for (FeedbackDTO m: feedbacks)
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
		MainDispatcher.getInstance().callAction("Feedback", "doControl", this.request);
	}

}