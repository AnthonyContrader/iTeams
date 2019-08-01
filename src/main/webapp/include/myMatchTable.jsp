<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.MatchDTO" 
	import="it.contrader.dao.MatchDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.MatchService"
%>
		<%

			MatchDAO mDAO = new MatchDAO();
			
			MatchService myserviceMatch = new MatchService();
			List<MatchDTO> mylistMatchDTO = myserviceMatch.getMine(Integer.parseInt(session.getAttribute("iduser").toString()));
			List<MatchDTO> mylistMatch = (List<MatchDTO>) mylistMatchDTO;
		//	int idUser = Integer.parseInt(session.getAttribute("iduser").toString());
			request.setAttribute("iduser", session.getAttribute("iduser"));
			//request.setAttribute("listmatch", listMatchDTO);
			
		
			
		%>
		



	

	<br>
	
	<table>
		<tr><td colspan="8">MY MATCH</td></tr>
		<tr>
			<th>ID MATCH </th>
			<th>ID SPORT</th>
			<th>RATE</th>
			<th>ADDRESS</th>
			<th>TIME</th>
			<th>STATUS</th>
			<th colspan="2">OPTION</th>
		</tr>
		<%
			for (MatchDTO m : mylistMatch) {
		%>
		<tr>
			<td><%=m.getId()%></td>
			<td><%=m.getIdSport()%></td>
			<td><%=m.getRate()%></td>
			<td><%=m.getAddress()%></td>
			<td><%=m.getMatchtime()%></td>
			<% if(!m.isStatus()){ %>
			<td>Incomplete</td>
			<%}else{%>
			<td>Complete</td>
			<%}%>
			<td><a href=MatchServlet?mode=read&update=true&id=<%=m.getId()%>>Edit</a>
			</td>
			<td><a href=MatchServlet?mode=delete&id=<%=m.getId()%>>Delete</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>