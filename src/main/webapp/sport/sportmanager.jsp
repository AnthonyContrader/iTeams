<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SportDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Sport Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/sportmenu.jsp" %>

<div class="main">
	<%
		List<SportDTO> list = (List<SportDTO>) request.getAttribute("list");
	%>

<br>

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
			<td><a href=SportServlet?mode=read&id=<%=s.getId()%>>
					<%=s.getName()%>
			</a></td>
			<td><%=s.getPlayers()%></td>
			<td><a href=SportServlet?mode=read&update=true&id=<%=s.getId()%>>Edit</a>
			</td>
			<td><a href=SportServlet?mode=delete&id=<%=s.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="SportServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Nome Sport</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="name" placeholder="inserisci nome dello sport">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="players">Numero Giocatori</label>
    </div>
    <div class="col-75">
      <input type="number" id="pass" name="players" placeholder="inserisci numero giocatori"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>

<br>
<%@ include file="../include/joinSportTable.jsp"%>
<br>
<%@ include file="../include/unjoinSportTable.jsp"%>
<br><%@ include file="../css/footer.jsp" %>
</body>
</html>