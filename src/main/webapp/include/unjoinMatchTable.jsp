<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.MatchDTO" 
	import="it.contrader.dao.MatchDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.MatchService"
%>
		<%

			MatchDAO unDAO = new MatchDAO();
			
			MatchService unserviceMatch = new MatchService();
			List<MatchDTO> unlistMatchDTO = unserviceMatch.getJoined(Integer.parseInt(session.getAttribute("iduser").toString()));
			List<MatchDTO> unlistMatch = (List<MatchDTO>) unlistMatchDTO;
		//	int idUser = Integer.parseInt(session.getAttribute("iduser").toString());
			request.setAttribute("iduser", session.getAttribute("iduser"));
			//request.setAttribute("listmatch", unlistMatchDTO);
			
		
			
		%>
		



	

	<br>
	
	<table>
		<tr><td colspan="7">JOINED MATCH</td></tr>
		<tr>
			<th>ID MATCH </th>
			<th>ID SPORT</th>
			<th>ID PROPOSER</th>
			<th>RATE</th>
			<th>ADDRESS</th>
			<th>TIME</th>
			<th></th>
		</tr>
		<%
			for (MatchDTO m : unlistMatch) {
		%>
		<tr>
			<td><%=m.getId()%></td>
			<td><%=m.getIdSport()%></td>
			<td><%=m.getIdUser()%></td>
			<td><%=m.getRate()%></td>
			<td><%=m.getAddress()%></td>
			<td><%=m.getMatchtime()%></td>
			<% if(!m.isStatus()){ %>
			<td>
			<a href="JoinMatchServlet?mode=unjoin&idmatch=<%=m.getId()%>">UNJOIN MATCH</a></td>
			<%}else{%>
			<td></td>
			<%}%>
		</tr>
		<%
			}
		%>
	</table>