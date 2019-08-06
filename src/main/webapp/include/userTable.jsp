			<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import= "it.contrader.model.User"
	import="it.contrader.dto.UserDTO" 
	import="it.contrader.dao.UserRepository"
	import="it.contrader.service.Service"
	import="it.contrader.service.UserService"%>
	
			
			
			<%
			List<UserDTO> listUser= (List<UserDTO>) request.getAttribute("allUserDTO");
			
			
		%>

	<table>
	<tr><td colspan="3">USERS</td></tr>
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