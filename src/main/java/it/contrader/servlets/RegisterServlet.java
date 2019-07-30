package it.contrader.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.UserService;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean ans;

		UserDTO userDTO = new UserDTO();

		String username = request.getParameter("userName");
		String password = request.getParameter("userPass");

		try {

			userDTO.setUsername(username);
			userDTO.setPassword(password);
			userDTO.setUsertype("user");

			Service<UserDTO> service = new UserService();

			ans = service.insert(userDTO);

			if (ans) {
				out.print("You are successfully registered...");
			}
					
			
		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}