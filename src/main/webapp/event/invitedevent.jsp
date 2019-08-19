<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.Set"
	import="it.contrader.dto.EventDTO"
	import="it.contrader.model.Event" 
	import="it.contrader.dto.UserDTO"
	import="it.contrader.model.User"
	import="it.contrader.dto.SportDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="img/icona.png" />
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Sport Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>

	<div class="main">
		<%
			User creator = (User) session.getAttribute("utente");
			Set<Event> set= creator.getInvitedEvent();
		%>

		<br>
		<%
			if (session.getAttribute("usertype").toString().toUpperCase().contains("USER")) {
		%>

		<table>
			<tr>
				<th>Creator</th>
				<th>Sport Name</th>
				<th>Location</th>
				<th>Time</th>
				<th>Rate</th>
				<th>Joiners</th>
				<th>Status</th>
				<th colspan="2">Options</th>
			</tr>
			<%
				for (Event e : set) {
			%>
			<tr>
				<td><%=e.getUser().getUsername()%></td>
				<td><%=e.getSport().getName()%></td>
				<td><a href="../Event/readevent" <%=e.getId()%>><%=e.getCity() + " " + e.getAddress()%></a></td>
				<td><%=e.getMatchtime()%></td>
				<td><%=e.getRate()%></td>
				<td><%=e.getJoiners().size()%></td>
				<%
					if (e.getStatus()) {
				%>
				<td>Complete</td>
				<%
					} else {
				%>
				<td>Incomplete</td>
				<%
					}
				%>
				<%
					if (e.getUser().getId()==creator.getId()) {
				%>
				<td><a href="../Event/redirectupdate?idUpdate=<%=e.getId()%>">Edit</a>
				</td>
				<td><a href="../Event/deleteevent?id=<%=e.getId()%>">Delete</a>
				</td>
				<%
				}
				%>
				<td><a href="../Event/redirectinvite?idEvent=<%=e.getId()%>">Invite User</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>

		<%-- 
		<%
		if(session.getAttribute("usertype").toString().toUpperCase().contains("USER") ){
			
		%>

		<table>
			<tr>
				<th>Sport Name</th>
				<th>Number of Players</th>
				<th></th>
				<th></th>
			</tr>
			<%
		
			for (SportDTO s : list) {
		%>
			<tr>
				<td><a href="../Sport/readsport" <%=s.getId()%>> <%=s.getName()%>
				</a></td>
				<td><%=s.getPlayers()%></td>
				<td><a href=#>JOIN</a>
			</tr>
			<%
			}
		
		%>
		</table>
		<%
			}
		
		%> --%>



		
	</div>

	<br>
</body>
</html>