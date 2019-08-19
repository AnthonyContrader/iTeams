<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.EventDTO" 
	import="it.contrader.dto.UserDTO"
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
			UserDTO creator = (UserDTO) session.getAttribute("utenteCollegato");
			List<EventDTO> list = (List<EventDTO>) request.getAttribute("allEventDTO");
			List<SportDTO> sportList = (List<SportDTO>) request.getAttribute("allSportDTO");
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
				for (EventDTO e : list) {
			%>
			<tr>
				<td><%=e.getUserDTO().getUsername()%></td>
				<td><%=e.getSportDTO().getName()%></td>
				<td><a href="../Event/readevent" <%=e.getId()%>><%=e.getCity() + " " + e.getAddress()%></a></td>
				<td><%=e.getMatchtime()%></td>
				<td><%=e.getRate()%></td>
				<td><%=e.getJoinersInt()%></td>
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
					if (e.getUserDTO().getId()==creator.getId()) {
				%>
				<td><a href="../Event/redirectupdate?idUpdate=<%=e.getId()%>">Edit</a>
				</td>
				<td><a href="../Event/deleteevent?id=<%=e.getId()%>">Delete</a>
				</td>
				<%
				}else{
				%>
				<td></td>
				<td></td>
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



		<%
			if (session.getAttribute("usertype").toString().toUpperCase().contains("USER")) {
		%>
		<form id="floatright" action="../Event/insertevent" method="post">
			<input type="hidden" name="creator" value=<%=creator.getId()%>>
			<div class="row">
				<div class="col-25">
					<label for="idsport">ID SPORT</label>
				</div>
				<div class="col-75">
					<select id="sport" name="idsport">
						<%
							for (SportDTO s : sportList) {
						%>
						<option value=<%=s.getId()%>><%=s.getName()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">RATE</label>
				</div>
				<div class="col-75">
					<input type="number" min="1" max="5" id="rate" name="rate"
						placeholder="insert rate">
				</div>

			</div>
			<div class="row">
				<div class="col-25">
					<label for="city">City</label>
				</div>
				<div class="col-75">
					<input type="text" id="city" name="city"
						placeholder="insert city">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="address">Address</label>
				</div>
				<div class="col-75">
					<input type="text" id="address" name="address"
						placeholder="insert address">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="time">Event time</label>
				</div>
				<div class="col-75">
					<input type="text" id="time" name="time"
						placeholder="insert event time">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>
		<%
			}
		%>

	</div>

	<br>
</body>
</html>