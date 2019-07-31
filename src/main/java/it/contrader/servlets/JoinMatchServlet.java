package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dao.JoinMatchDAO;
import it.contrader.dto.JoinMatchDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.LoginService;

public class JoinMatchServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);


		if (request != null) {
			String mode = request.getParameter("mode").toString();

			int idUser = Integer.parseInt(request.getParameter("idUser").toString());
			int idMatch = Integer.parseInt(request.getParameter("idMatch").toString());			
			
			switch (mode) {
			case "JOIN":
				JoinMatchDTO jmDTO = new JoinMatchDTO(idMatch,idUser);
				JoinMatchDAO jmDAO = new JoinMatchDAO();
				jmDAO.insert(jmDTO);
				break;

			case "UNJOIN":
				jmDTO = new JoinMatchDTO(idMatch,idUser);
				jmDAO = new JoinMatchDAO();
				jmDAO.delete(jmDTO);				
				break;

			}
		}
	}

}
