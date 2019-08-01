package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dao.JoinMatchDAO;
import it.contrader.dao.JoinSportDAO;
import it.contrader.dto.JoinMatchDTO;
import it.contrader.dto.JoinSportDTO;
import it.contrader.dto.MatchDTO;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.LoginService;
import it.contrader.service.MatchService;
import it.contrader.service.Service;
import it.contrader.service.SportService;

public class JoinSportServlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void updateList(HttpServletRequest request) {
		Service<SportDTO> service = new SportService();
		List<SportDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		boolean ans;
		

		if (request != null) {
			String mode = request.getParameter("mode").toString();

			//int idUser = Integer.parseInt(session.getAttribute("iduser").toString());
			int idSport = Integer.parseInt(request.getParameter("idsport").toString());			
			
			switch (mode.toUpperCase()) {
			case "JOIN":
				JoinSportDTO jsDTO = new JoinSportDTO(idSport,Integer.parseInt(session.getAttribute("iduser").toString()));
				JoinSportDAO jsDAO = new JoinSportDAO();
				ans = jsDAO.insert(jsDTO);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/sport/sportmanager.jsp").forward(request, response);
				break;

			case "UNJOIN":
				jsDTO = new JoinSportDTO(idSport,Integer.parseInt(session.getAttribute("iduser").toString()));
				jsDAO = new JoinSportDAO();
				ans=jsDAO.delete(jsDTO);		
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/sport/sportmanager.jsp").forward(request, response);
				break;

			}
		}
	}

}