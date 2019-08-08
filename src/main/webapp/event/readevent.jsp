<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EventDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="img/icona.png" />
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Event</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<%@ include file="../css/menu.jsp" %>

<br>

<div class="main">

<%EventDTO e = (EventDTO) request.getAttribute("eventById");%>


<table>
	<tr> 
		<th>Sport</th>
		<th>User</th>
		<th>Rate</th>
		<th>City</th>
		<th>Address</th>
		<th>Match time</th>
		<th>Status</th>
	</tr>
	<tr>
		<td> <%=e.getSportName()%></td>
		<td> <%=e.getUserName()%></td>
		<td> <%=e.getRate()%></td>
		<td> <%=e.getCity()%></td>
		<td> <%=e.getAddress()%></td>
		<td> <%=e.getMatchtime()%></td>
		<td> <%=e.getStatus()%></td>
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