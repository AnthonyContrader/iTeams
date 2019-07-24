package it.contrader.view.match;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MatchInsertView extends AbstractView{
	private Request request;

	private int idSport;
	private int idUser;
	private int rate;
	private String address;
	private String matchtime;
	private final String mode = "INSERT";

	public MatchInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			//MainDispatcher.getInstance().callView("Match", null);
			request.put("mode", "MATCHLIST");
			MainDispatcher.getInstance().callAction("Match", "doControl", request);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'utente:");
			idUser = Integer.parseInt(getInput());
			System.out.println("Inserisci id dello sport:");
			idSport = Integer.parseInt(getInput());
			System.out.println("Inserisci il livello della partita:");
			rate = Integer.parseInt(getInput());
			System.out.println("Inserisci l'indirizzo:");
			address = getInput();
			System.out.println("Inserisci la data:");
			matchtime = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idSport", idSport);
		request.put("idUser", idUser);
		request.put("rate", rate);
		request.put("address", address);
		request.put("matchtime", matchtime);		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Match", "doControl", request);
	}


}
