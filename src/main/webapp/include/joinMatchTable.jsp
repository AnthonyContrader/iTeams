<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.MatchDTO" 
	import="it.contrader.dao.MatchDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.MatchService"
%>
		<%

			MatchDAO sDAO = new MatchDAO();
			
			MatchService serviceMatch = new MatchService();
			List<MatchDTO> listMatchDTO = serviceMatch.getNotJoined(Integer.parseInt(session.getAttribute("iduser").toString()));
			List<MatchDTO> listMatch = (List<MatchDTO>) listMatchDTO;
		//	int idUser = Integer.parseInt(session.getAttribute("iduser").toString());
			request.setAttribute("iduser", session.getAttribute("iduser"));
			//request.setAttribute("listmatch", listMatchDTO);
			
		
			
		%>
		



	

	<br>
	
	<table>
		<tr><td colspan="7">UNJOINED MATCH</td></tr>
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
			for (MatchDTO m : listMatch) {
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
			<a href="JoinMatchServlet?mode=join&idmatch=<%=m.getId()%>">JOIN MATCH</a></td>
			<%}else{%>
			<td></td>
			<%}%>
		</tr>
		<%
			}
		%>
	</table>