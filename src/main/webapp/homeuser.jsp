<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO" 
	import="it.contrader.dao.UserDAO"
	import="it.contrader.dto.FeedbackDTO"
	import="it.contrader.dao.FeedbackDAO"
	import="it.contrader.dto.SportDTO" 
	import="it.contrader.dao.SportDAO"
	import="it.contrader.dto.MatchDTO" 
	import="it.contrader.dao.MatchDAO"
	import="it.contrader.service.Service"
	import="it.contrader.service.FeedbackService"
	import="it.contrader.service.SportService"
	import="it.contrader.service.MatchService"
	import="it.contrader.service.UserService"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<link href="css/vittoriostyle.css" rel="stylesheet">

</head>
<body>




	<%@include file="css/header.jsp"%>
	
	<%@include file="css/homeusermenu.jsp"%>





	<div class="main">




		<h1>Welcome <%=session.getAttribute("utente")%></h1>
		
		<br>
		
		<h3>
			iTeams si basa su un sistema di feedback per organizzare squadre
			bilanciate per i tuoi sport preferiti.<br> Iscriviti e scegli i
			tuoi sport preferiti.<br> iTeams ti inviera' automaticamente
			degli inviti in base ai tornei organizzati nella tua citta'.<br>
			Dopo ogni partita dai un voto agli altri giocatori.<br>
		</h3>

		<table>
					
			<tr>
				<td>
					<br>
					<%@include file="include/userTable.jsp"%>
					<br>
				</td>
	
				<td>
					<br>
					<%@include file="include/sportTable.jsp"%>
					<br>
				</td>
	
			</tr>
		</table>
		

	</div>
	
		
	


	<%@ include file="css/footer.jsp"%>

</body>
</html>