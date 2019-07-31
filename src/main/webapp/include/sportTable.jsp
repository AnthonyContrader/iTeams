			<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SportDTO" 
	import="it.contrader.dao.SportDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.SportService"
%>


		<%

			SportDAO sDAO = new SportDAO();
			
			Service<SportDTO> serviceSport = new SportService();
			List<SportDTO> listSportDTO = serviceSport.getAll();
			List<SportDTO> listSport = (List<SportDTO>) listSportDTO;
			request.setAttribute("listsport", listSportDTO);
			
		
			
		%>

	
	<table>
		<tr><td colspan="3">SPORT</td></tr>
		<tr>
			<th>ID </th>
			<th>Sport</th>
			<th>N players</th>
		</tr>
		<%
			for (SportDTO s : listSport) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getPlayers()%></td>
			
		</tr>
		<%
			}
		%>
	</table>