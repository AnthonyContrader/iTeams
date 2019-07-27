package it.contrader.view.match;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MatchInsertView extends AbstractView{
	private Request request;

	private int idSport;
	private int idUser;
	private int rate;
	private String address;
	private java.util.Date matchtime;
	private final String mode = "INSERT";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public MatchInsertView() {
	}
	

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			request.put("mode", "MATCHLIST");
			MainDispatcher.getInstance().callAction("Match", "doControl", request);
		}
	}

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
			System.out.println("Inserisci la data nel formato YYYY-MM-DD HH:MM:SS :");
			try {
				matchtime = sdf.parse((getInput()));
			} catch (ParseException e) {
				System.err.println("errore nella conversione della stringa");
			}
	}

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