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
<%@ include file="../css/sportmenu.jsp" %>
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