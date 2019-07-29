<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MatchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Match</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="matchServlet?mode=matchlist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%MatchDTO f = (MatchDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Sport</th>
		<th>User</th>
		<th>Rate</th>
		<th>Address</th>
		<th>Matchtime</th>
	</tr>
	<tr>
		<td><%= f.getIdSport()%></td>
		<td> <%=f.getIdUser()%></td>
		<td> <%=f.getRate()%></td>
		<td> <%=f.getAddress()%></td>
		<td> <%=f.getMatchtime()%></td>
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