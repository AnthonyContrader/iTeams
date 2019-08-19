<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.EventDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="img/icona.png" />
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@ include file="../css/menu.jsp"%>

	<div class="main">
		<%
			EventDTO event = (EventDTO)request.getAttribute("evento");
			List<UserDTO> list = (List<UserDTO>) request.getAttribute("allUserDTO");
		%>

		<br>

		<table>
			<tr>
				<th>Username</th>
				<th>Usertype</th>
				<th colspan="2">Options</th>
			</tr>
			<%
				for (UserDTO u : list) {
					if (!session.getAttribute("usertype").toString().toUpperCase().contains("ADMIN")) {
						//if(u.getId()==Integer.parseInt(session.getAttribute("id").toString())){
						if (u.getUsertype().toUpperCase().contains("USER")) {
			%>
			<tr>
				<td><a href=User/readuser?idU= <%=u.getId()%>> <%=u.getUsername()%>
				</a></td>
				<td><%=u.getUsertype()%></td>
				<td><a href="../Event/inviteuser?idInvite=<%=u.getId()%>">Invite</a></td>
				<td><a href="../User/sendmessage?idMessage=<%=u.getId()%>">Send
						a message</a></td>
			</tr>
			<%
				} else {
			%>
			<tr>
				<td><a href="../User/readuser?idU=<%=u.getId()%>"> <%=u.getUsername()%>
				</a></td>
				<td><%=u.getUsertype()%></td>
				<td></td>
				<td><a href="../User/sendmessage?idMessage=<%=u.getId()%>">Send
						a message</a></td>
			</tr>

			<%
				}
					}
				}
			%>
		</table>

		<%
			if (session.getAttribute("usertype").toString().toUpperCase().contains("ADMIN")) {
		%>

		<form id="floatright" action="../User/insertUser" method="post">

			<div class="row">
				<div class="col-25">
					<label for="user">Username</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="username"
						placeholder="inserisci username">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Password</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="password"
						placeholder="inserisci password">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Usertype</label>
				</div>
				<div class="col-75">
					<select id="type" name="usertype">
						<option value="ADMIN">ADMIN</option>
						<option value="USER">USER</option>

					</select>
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>
		<%
			}
		%>
	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>