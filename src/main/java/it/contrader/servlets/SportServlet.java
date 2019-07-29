package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.SportDTO;
import it.contrader.service.Service;
import it.contrader.service.SportService;

public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	
	public SportServlet() {}
	
	public void updateList(HttpServletRequest request) {
		Service<SportDTO> service = new SportService();
		List<SportDTO> sportListDTO= service.getAll();
		request.setAttribute("list", sportListDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SportDTO> service = new SportService();
		String mode = request.getParameter("mode");
		SportDTO sportDTO;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
			
		case "SPORTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/sport/sportmanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			sportDTO = service.read(id);
			request.setAttribute("dto", sportDTO);
			
			if(request.getParameter("update")==null) {
				getServletContext().getRequestDispatcher("/sport/readsport.jsp").forward(request, response);
			}
			else
				getServletContext().getRequestDispatcher("/sport/updatesport.jsp").forward(request, response);
				
			break;
			
		case "INSERT":
			String name = request.getParameter("name").toString();
			int players = Integer.parseInt(request.getParameter("players"));
			sportDTO = new SportDTO(name, players);
			ans = service.insert(sportDTO);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/sport/sportmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name").toString();
			players = Integer.parseInt(request.getParameter("players"));
			id = Integer.parseInt(request.getParameter("id"));
			sportDTO = new SportDTO(id, name, players);
			ans = service.update(sportDTO);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/sport/sportmanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id= Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/sport/sportmanager.jsp").forward(request, response);
			break;				
		
		}
	}
}
