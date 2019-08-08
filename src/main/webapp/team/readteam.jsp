<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.contrader.dto.TeamDTO"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Team</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp" %>
<br>

<div class="main">


<%TeamDTO f = (TeamDTO) request.getAttribute("dto");%>



<table>
	<tr> 
		<th>Name</th>
		<th>Sport</th>
		<th>Players</th>
	</tr>
	<tr>
		<td> <%=f.getName()%></td>
		<td><%= f.getIdSport()%></td>
		<td> <%=f.getPlayers()%></td>
		
	</tr>	
</table>




</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>