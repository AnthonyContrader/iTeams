<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FeedbackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Feedback</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp" %>
<br>

<div class="main">
<%FeedbackDTO f = (FeedbackDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Sport</th>
		<th>User</th>
		<th>Rate</th>
	</tr>
	<tr>
		<td><%= f.getIdSport()%></td>
		<td> <%=f.getIdUser()%></td>
		<td> <%=f.getRate()%></td>
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