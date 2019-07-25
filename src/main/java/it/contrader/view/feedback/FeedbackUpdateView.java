package it.contrader.view.feedback;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class FeedbackUpdateView extends AbstractView {
	private Request request;

	private int id;
	private int idSport;
	private int idUser;
	private int rate;
	private String address;
	private String feedbacktime;

	private final String mode = "UPDATE";

	public FeedbackUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Feedback", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			id=0;
			idSport=0;
			idUser=0;
			rate=0;
			System.out.println("Inserisci id del feedback da aggiornare:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci id dell'utente:");
			idUser = Integer.parseInt(getInput());
			System.out.println("Inserisci id dello sport:");
			idSport = Integer.parseInt(getInput());
			System.out.println("Inserisci il livello della partita:");
			rate = Integer.parseInt(getInput());
			System.out.println("Inserisci l'indirizzo:");
			address = getInput();
			System.out.println("Inserisci la data:");
			feedbacktime = getInput();
			
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
				
		request = new Request();
		request.put("id", id);
		request.put("idSport", idSport);
		request.put("idUser", idUser);
		request.put("rate", rate);
		request.put("address", address);
		request.put("feedbacktime", feedbacktime);		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Feedback", "doControl", request);
		
	}

}
