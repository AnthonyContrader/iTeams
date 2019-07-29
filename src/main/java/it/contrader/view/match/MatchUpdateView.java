package it.contrader.view.match;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class MatchUpdateView extends AbstractView {
	private Request request;

	private int id;
	private int idSport;
	private int idUser;
	private int rate;
	private String address;
	private Date matchtime;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final String mode = "UPDATE";

	public MatchUpdateView() {
	}


	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			request.put("mode", "MATCHLIST");
			MainDispatcher.getInstance().callAction("Match", "doControl", request);
		}
	}

	@Override
	public void showOptions() {
		try {
			id=0;
			idSport=0;
			idUser=0;
			rate=0;
			System.out.println("Inserisci id del match da aggiornare:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci id dell'utente:");
			idUser = Integer.parseInt(getInput());
			System.out.println("Inserisci id dello sport:");
			idSport = Integer.parseInt(getInput());
			System.out.println("Inserisci il livello della partita:");
			rate = Integer.parseInt(getInput());
			System.out.println("Inserisci l'indirizzo:");
			address = getInput();
			System.out.println("Inserisci la data nel formato YYYY-MM-DD HH:MM :");
			try {
				matchtime = sdf.parse(getInput()+":00");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.err.println("errore nella conversione della stringa");
			}
			
		} catch (Exception e) {

		}
	}


	@Override
	public void submit() {
				
		request = new Request();
		request.put("id", id);
		request.put("idSport", idSport);
		request.put("idUser", idUser);
		request.put("rate", rate);
		request.put("address", address);
		request.put("matchtime", matchtime);		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Match", "doControl", request);
		
	}

}