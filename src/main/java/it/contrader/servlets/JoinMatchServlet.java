package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dao.JoinMatchDAO;
import it.contrader.dto.JoinMatchDTO;
import it.contrader.dto.MatchDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.LoginService;
import it.contrader.service.MatchService;
import it.contrader.service.Service;

public class JoinMatchServlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void updateList(HttpServletRequest request) {
		Service<MatchDTO> service = new MatchService();
		List<MatchDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		boolean ans;
		

		if (request != null) {
			String mode = request.getParameter("mode").toString();

			//int idUser = Integer.parseInt(session.getAttribute("iduser").toString());
			int idMatch = Integer.parseInt(request.getParameter("idmatch").toString());			
			
			switch (mode.toUpperCase()) {
			case "JOIN":
				JoinMatchDTO jmDTO = new JoinMatchDTO(idMatch,Integer.parseInt(session.getAttribute("iduser").toString()));
				JoinMatchDAO jmDAO = new JoinMatchDAO();
				ans = jmDAO.insert(jmDTO);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/match/matchmanager.jsp").forward(request, response);
				break;

			case "UNJOIN":
				jmDTO = new JoinMatchDTO(idMatch,Integer.parseInt(session.getAttribute("iduser").toString()));
				jmDAO = new JoinMatchDAO();
				jmDAO.delete(jmDTO);				
				break;

			}
		}
	}

}
