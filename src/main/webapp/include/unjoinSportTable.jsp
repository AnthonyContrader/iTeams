<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.SportDTO" 
	import="it.contrader.dao.SportDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.SportService"
%>
		<%

			SportDAO unDAO = new SportDAO();
			
			SportService unserviceSport = new SportService();
			List<SportDTO> unlistSportDTO = unserviceSport.getJoined(Integer.parseInt(session.getAttribute("iduser").toString()));
			List<SportDTO> unlistSport = (List<SportDTO>) unlistSportDTO;
		//	int idUser = Integer.parseInt(session.getAttribute("iduser").toString());
			request.setAttribute("iduser", session.getAttribute("iduser"));
			//request.setAttribute("listmatch", listMatchDTO);
			
		
			
		%>
		



	

	<br>
	
	<table>
		<tr><td colspan="4">JOINED SPORT</td></tr>
		<tr>
			<th>ID SPORT</th>
			<th>SPORT</th>
			<th>PLAYERS per MATCH</th>
			<th>OPTIONS</th>
		</tr>
		<%
			for (SportDTO s : unlistSport) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getPlayers()%></td>
			<td><a href="JoinSportServlet?mode=unjoin&idsport=<%=s.getId()%>">UNJOIN SPORT</a></td>
		</tr>
		<%
			}
		%>
	</table>