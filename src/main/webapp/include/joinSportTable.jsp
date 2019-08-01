<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.SportDTO" 
	import="it.contrader.dao.SportDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.SportService"
%>
		<%

			SportDAO sDAO = new SportDAO();
			
			SportService serviceSport = new SportService();
			List<SportDTO> listSportDTO = serviceSport.getNotJoined(Integer.parseInt(session.getAttribute("iduser").toString()));
			List<SportDTO> listSport = (List<SportDTO>) listSportDTO;
		//	int idUser = Integer.parseInt(session.getAttribute("iduser").toString());
			request.setAttribute("iduser", session.getAttribute("iduser"));
			//request.setAttribute("listmatch", listMatchDTO);
			
		
			
		%>
		



	

	<br>
	
	<table>
		<tr><td colspan="4">UNJOINED SPORT</td></tr>
		<tr>
			<th>ID SPORT</th>
			<th>SPORT</th>
			<th>PLAYERS per MATCH</th>
			<th>OPTIONS</th>
		</tr>
		<%
			for (SportDTO s : listSport) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getPlayers()%></td>
			<td><a href="JoinSportServlet?mode=join&idsport=<%=s.getId()%>">JOIN SPORT</a></td>
		</tr>
		<%
			}
		%>
	</table>