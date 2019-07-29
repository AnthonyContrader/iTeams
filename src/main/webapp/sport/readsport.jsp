<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SportDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="SportServlet?mode=sportlist">Sport</a>
  <a href="FeedbackServlet?mode=feedbacklist">Feedback</a>
  <a href="UserServlet?mode=userlist">User</a>
  <a href="MatchServlet?mode=matchlist">Match</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%SportDTO s = (SportDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Sport Name</th>
		<th>Number of Players</th>
	</tr>
	<tr>
		<td><%=s.getName()%></td>
		<td> <%=s.getPlayers()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>