<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SportDTO"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="img/icona.png" />
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Sport Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp" %>

<div class="main">
	<%
		List<SportDTO> list = (List<SportDTO>) request.getAttribute("sport");
	%>

<br>
<%
		if(session.getAttribute("usertype").toString().toUpperCase().contains("ADMIN") ){
			
		%>

	<table>
		<tr>
			<th>Sport Name</th>
			<th>Number of Players</th>
			<th></th>
			<th></th>
		</tr>
		<%
		
			for (SportDTO s : list) {
		%>
		<tr>
			<td><a href= "../Sport/readsport" 
			<%=s.getId()%>>
			<%=s.getName()%>
			</a></td>		
			<td><%=s.getPlayers()%></td>
			<td><a href="../Sport/redirectupdate?idUpdate=<%=s.getId()%>">Edit</a>
			</td>
			<td><a href="../Sport/deletesport?id=<%=s.getId()%>">Delete</a>
			</td>

		</tr>
		<%
			}
		
		%>
	</table>
		<%
			}
		
		%>
		<%
		if(session.getAttribute("usertype").toString().toUpperCase().contains("USER") ){
			
		%>

	<table>
		<tr>
			<th>Sport Name</th>
			<th>Number of Players</th>
			<th></th>
			<th></th>
		</tr>
		<%
		
			for (SportDTO s : list) {
		%>
		<tr>
			<td><a href= "../Sport/readsport" 
			<%=s.getId()%>>
			<%=s.getName()%>
			</a></td>		
			<td><%=s.getPlayers()%></td>
			<td><a href=#>JOIN</a>

		</tr>
		<%
			}
		
		%>
	</table>
		<%
			}
		
		%>
		
		

<% if (session.getAttribute("usertype").toString().toUpperCase().contains("ADMIN")){ %>

<form id="floatright" action="../Sport/insertsport" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Sport Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="name" placeholder="insert sport name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="players">Number of Players</label>
    </div>
    <div class="col-75">
      <input type="number" id="pass" name="players" placeholder="insert Number of Players"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>
<% } %>

</div>

<br>

<% if(!session.getAttribute("usertype").toString().toUpperCase().contains("ADMIN")){ %>

<%-- <%@ include file="../include/joinSportTable.jsp"%>
<br>
<%@ include file="../include/unjoinSportTable.jsp"%>
<%} %>
<br><%@ include file="../css/footer.jsp" %> --%>
<% } %>
</body>
</html>