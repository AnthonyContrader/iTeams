package it.contrader.servlets;

import java.util.Date;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.MatchDTO;
import it.contrader.service.Service;
import it.contrader.service.MatchService;

public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public MatchServlet() {
		}
	
	public void updateList(HttpServletRequest request) {
		Service<MatchDTO> service = new MatchService();
		List<MatchDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<MatchDTO> service = new MatchService();
		String mode = request.getParameter("mode");
		MatchDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "MATCHLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/match/matchmanager.jsp").forward(request, response);
			
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/match/readmatch.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/match/updatematch.jsp").forward(request, response);
			
			break;

		case "INSERT":
			int idSport = Integer.parseInt(request.getParameter("idSport"));
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			int rate = Integer.parseInt(request.getParameter("rate"));
			String address = request.getParameter("address").toString();
			Date matchtime = java.sql.Date.valueOf(request.getParameter("matchtime"));
			
			dto = new MatchDTO (idSport, idUser, rate, address, matchtime);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/match/matchmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			idSport = Integer.parseInt(request.getParameter("idSport"));
			idUser = Integer.parseInt(request.getParameter("password"));
			rate = Integer.parseInt(request.getParameter("usertype"));
			address = request.getParameter("address").toString();
			Date matchtimeu = java.sql.Date.valueOf(request.getParameter("matchtime"));
			
			dto = new MatchDTO (idSport, idUser, rate, address, matchtimeu);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/match/matchmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/matchmatchmanager.jsp").forward(request, response);
			break;
		}
	}
}

	