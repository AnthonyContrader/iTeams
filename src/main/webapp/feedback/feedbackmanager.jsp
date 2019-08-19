<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.FeedbackDTO"
	import="it.contrader.dto.SportDTO"
	import="it.contrader.dto.UserDTO"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="img/icona.png" />
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Feedback Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<%@ include file="../css/menu.jsp"%>

	<div class="main">



		<%
			UserDTO connected = (UserDTO) session.getAttribute("utenteCollegato");
			List<UserDTO> userList = (List<UserDTO>) request.getAttribute("allUserDTO");
			List<SportDTO> sportList = (List<SportDTO>) request.getAttribute("allSportDTO");
			List<FeedbackDTO> list = (List<FeedbackDTO>) request.getAttribute("allFeedbackDTO");
		%>

		<br>

		<table>
			<tr>
				<th>ID SPORT</th>
				<th>ID USER</th>
				<th>RATE</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (FeedbackDTO f : list) {
			%>
			<tr>

				<td><a href="../Feedback/readfeedback" <%=f.getId()%>> <%=f.getSportDTO().getName()%>
				</a></td>

				<td><%=f.getUserDTO().getUsername()%></td>
				<td><%=f.getRate()%></td>

				<td><a href="../Feedback/updatefeedback" <%=f.getId()%>>Edit</a>
				</td>
				<td><a href="../Feedback/deletefeedback" <%=f.getId()%>>Delete</a>
				</td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="../Feedback/insertfeedback"
			method="post">
			<input type="hidden" name="creator" value=<%=connected.getId()%>>
			<div class="row">
				<div class="col-25">
					<label for="idsport">USER</label>
				</div>
				<div class="col-75">
					<select id="user" name="iduser">
						<%
							for (UserDTO u : userList) {
						%>
						<option value=<%=u.getId()%>><%=u.getUsername()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
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
						placeholder="inserisci rate">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>