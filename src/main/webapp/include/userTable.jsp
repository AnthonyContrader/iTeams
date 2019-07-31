			<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO" 
	import="it.contrader.dao.UserDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.UserService"%>
	
			
			
			<%
			
			UserDAO uDAO = new UserDAO();

			Service<UserDTO> serviceUser = new UserService();
			List<UserDTO> listUserDTO = serviceUser.getAll();
			List<UserDTO> listUser = (List<UserDTO>) listUserDTO;
			request.setAttribute("listuser", listUserDTO);
			
			
			
		%>
	
	
	<h2>User</h2>

	<br>
	
	<table>
		<tr>
			<th>ID </th>
			<th>Name</th>
			<th>Password</th>
			<th>Type</th>
		</tr>
		<%
		
			for (UserDTO u : listUser) {
				
				
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getUsername()%></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getUsertype()%></td>
			
		</tr>
		<%
				
			}
		%>
	</table>