package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	
	private Request request;

	@Override
	public void showResults(Request request) {
		if(request!=null) {
	    	System.out.println("\n Benvenuto in iTeams PROJECT "+request.get("username").toString() + "\n");
	    	}
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        //System.out.println("[M]atch [F]eedback [E]sci");
        System.out.println("[M]atch [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
        choice = this.getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		switch (choice) {
		case "m":
			this.request.put("mode", "MATCHLIST");
			MainDispatcher.getInstance().callAction("Match", "doControl", request);
			break;
		case "f": 			
			this.request.put("mode", "FEEDBACKLIST");
			MainDispatcher.getInstance().callAction("Feedback", "doControl", request);
			break;
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
