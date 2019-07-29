<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO" import="it.contrader.dao.UserDAO"
	import="it.contrader.dto.FeedbackDTO"
	import="it.contrader.dao.FeedbackDAO"
	import="it.contrader.dto.SportDTO" import="it.contrader.dao.SportDAO"
	import="it.contrader.dto.MatchDTO" import="it.contrader.dao.MatchDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.FeedbackService"
	import="it.contrader.service.SportService"
	import="it.contrader.service.MatchService"
	import="it.contrader.service.UserService"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
	<%@include file="css/header.jsp"%>
	
	<%@include file="css/homeadminmenu.jsp"%>




	<div class="main">


		<%
			FeedbackDAO fDAO = new FeedbackDAO();
			SportDAO sDAO = new SportDAO();
			MatchDAO mDAO = new MatchDAO();
			UserDAO uDAO = new UserDAO();

			Service<FeedbackDTO> serviceFeedback = new FeedbackService();
			List<FeedbackDTO> listFeedbackDTO = serviceFeedback.getAll();
			List<FeedbackDTO> listFeedback = (List<FeedbackDTO>) listFeedbackDTO;// listFeedback conteins the jsp feedback data
			request.setAttribute("listfeedback", listFeedbackDTO);
			
			Service<SportDTO> serviceSport = new SportService();
			List<SportDTO> listSportDTO = serviceSport.getAll();
			List<SportDTO> listSport = (List<SportDTO>) listSportDTO;
			request.setAttribute("listsport", listSportDTO);
			
			Service<MatchDTO> serviceMatch = new MatchService();
			List<MatchDTO> listMatchDTO = serviceMatch.getAll();
			List<MatchDTO> listMatch = (List<MatchDTO>) listMatchDTO;
			request.setAttribute("listmatch", listMatchDTO);
			
			Service<UserDTO> serviceUser = new UserService();
			List<UserDTO> listUserDTO = serviceUser.getAll();
			List<UserDTO> listUser = (List<UserDTO>) listUserDTO;
			request.setAttribute("listuser", listUserDTO);
			
			
			
		%>


		<h1>Welcome</h1>

		<h3>
			iTeams si basa su un sistema di feedback per organizzare squadre
			bilanciate per i tuoi sport preferiti.<br> Iscriviti e scegli i
			tuoi sport preferiti.<br> iTeams ti inviera' automaticamente
			degli inviti in base ai tornei organizzati nella tua citta'.<br>
			Dopo ogni partita dai un voto agli altri giocatori.<br>
		</h3>

	</div>
	<h2>User</h2>

	<br>
	
	<table>
		<tr>
			<th>ID </th>
			<th>Name</th>
			<th>Password</th>
			<th>Type</th>
		</tr>
		<%
			for (UserDTO u : listUser) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getUsername()%></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getUsertype()%></td>
			
		</tr>
		<%
			}
		%>
	</table>
	<br>


	<h2>Sport</h2>

	<br>
	
	<table>
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
	<br>
	
	<h2>Match</h2>

	<br>
	
	<table>
		<tr>
			<th>ID </th>
			<th>ID Sport</th>
			<th>ID User</th>
			<th> Rate</th>
			<th> Address</th>
			<th> Match Time</th>
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
			
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<h2>Feedback</h2>

	<br>
	
	<table>
		<tr>
			<th>ID </th>
			<th>ID Sport</th>
			<th>ID User</th>
			<th>ID Rate</th>
		</tr>
		<%
			for (FeedbackDTO f : listFeedback) {
		%>
		<tr>
			<td><%=f.getId()%></td>
			<td><%=f.getIdSport()%></td>
			<td><%=f.getIdUser()%></td>
			<td><%=f.getRate()%></td>
			
		</tr>
		<%
			}
		%>
	</table>
	<br>

	<%@ include file="css/footer.jsp"%>

</body>
</html>