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
		
		String bt = request.getParameter("register");
		String bb = request.getParameter("back");
		
		if(bb !=null) {
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
			
		}
				
		//getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);

		boolean login = false;
		
		
		String mode = request.getParameter("mode");
		
		if(bt !=null) {
			
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
					System.out.println("You are successfully registered!");
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
				
				
			} catch (Exception e2) {
				System.out.println(e2);
			}

		}
	}

}