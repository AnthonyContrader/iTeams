package it.contrader.controller;

import java.util.List;

import it.contrader.dto.SportDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.SportService;

public class SportController implements Controller {

	private static String sub_package = "sport.";

	private SportService sportService;

	public SportController() {

		this.sportService = new SportService();

	}

	@Override
	public void doControl(Request request) {

		String mode = (String) request.get("mode");

		String choice = (String) request.get("choice");

		int id;
		int players;
		String name;

		switch (mode) {

		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			SportDTO sportDTO = sportService.read(id);
			request.put("sport", sportDTO);
			MainDispatcher.getInstance().callView(sub_package + "SportRead", request);
			break;

		case "INSERT":
			players = Integer.parseInt(request.get("players").toString());
			name = request.get("name").toString();
			SportDTO usertoinsert = new SportDTO(players, name);
			// invoca il service
			sportService.insert(usertoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SportInsert", request);
			break;

		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			// Qui chiama il service
			sportService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SportDelete", request);
			break;

		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			players = Integer.parseInt(request.get("players").toString());
			name = request.get("name").toString();
			SportDTO sporttoupdate = new SportDTO(players, name);
			sporttoupdate.setId(id);
			sportService.update(sporttoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SportUpdate", request);
			break;

		case "SPORTLIST":
			List<SportDTO> sportsDTO = sportService.getAll();
			request.put("sport", sportsDTO);
			MainDispatcher.getInstance().callView("Sport", request);
			break;

		case "GETCHOICE":
			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_package + "SportRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_package + "SportInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_package + "SportUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_package + "SportDelete", null);
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
