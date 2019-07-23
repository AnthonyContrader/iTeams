package it.contrader.controller;

import java.sql.Date;
import java.util.List;

import it.contrader.dto.MatchDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.MatchService;

public class MatchController implements Controller {

	private static String sub_package = "match.";

	private MatchService matchService;

	public MatchController() {

		this.matchService = new MatchService();

	}

	@Override
	public void doControl(Request request) {

		String mode = (String) request.get("mode");

		String choice = (String) request.get("choice");

		int id;
		int idSport;
		int idMatch;
		int rate;
		String address;
		Date matchtime;

		switch (mode) {

		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			MatchDTO matchDTO = matchService.read(id);
			request.put("match", matchDTO);
			MainDispatcher.getInstance().callView(sub_package + "MatchRead", request);
			break;

		case "INSERT":
			idSport = Integer.parseInt(request.get("idSport").toString());
			idMatch = Integer.parseInt(request.get("idMatch").toString());
			rate = Integer.parseInt(request.get("rate").toString());
			address = request.get("address").toString();
			matchtime = Date.valueOf(request.get("matchtime").toString());
			MainDispatcher.getInstance().callView(sub_package + "MatchInsert", request);
			break;

		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			idSport = Integer.parseInt(request.get("idSport").toString());
			idMatch = Integer.parseInt(request.get("idMatch").toString());
			rate = Integer.parseInt(request.get("rate").toString());
			address = request.get("address").toString();
			matchtime = Date.valueOf(request.get("matchtime").toString());
			MatchDTO matchtoupdate = new MatchDTO(idSport, idMatch, rate, address, matchtime);
			matchtoupdate.setId(id);
			matchService.update(matchtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "MatchUpdate", request);
			break;

		case "MATCHLIST":
			List<MatchDTO> matchsDTO = matchService.getAll();
			// Impacchetta la request con la lista degli user
			request.put("match", matchsDTO);
			MainDispatcher.getInstance().callView("Match", request);
			break;

		case "GETCHOICE":

			// toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_package + "MatchRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_package + "MatchInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_package + "MatchUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_package + "MatchDelete", null);
				break;

			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;

			default:
				MainDispatcher.getInstance().callView("Login", null);
			}

		default:
			MainDispatcher.getInstance().callView("Login", null);
		}

	}

}
