<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.FeedbackDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="SportServlet?mode=sportlist">Sport</a>
  <a href="MatchServlet?mode=matchlist">Match</a>
  <a href="FeedbackServlet?mode=feedbacklist">Feedback</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">


	
<h1>Welcome </h1>

<h3>
iTeams si basa su un sistema di feedback per organizzare squadre bilanciate per i tuoi sport preferiti.<br>
Iscriviti e scegli i tuoi sport preferiti.<br>
iTeams ti inviera' automaticamente degli inviti in base ai tornei organizzati nella tua citta'.<br>
Dopo ogni partita dai un voto agli altri giocatori.<br>
</h3> 

</div>
<h2>Feedback</h2>
	

<br>


<%@ include file="css/footer.jsp" %>

</body>
</html>