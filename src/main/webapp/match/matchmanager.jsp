<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.MatchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Match Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<%-- <%@ include file="../css/matchmenu.jsp" %> --%>
<%@ include file="../css/menu.jsp" %>

<div class="main">
	<%
	List<MatchDTO> list = (List<MatchDTO>) request.getAttribute("list");
	%>

<%--
<br>

	<table>
		<tr>
			<th>ID SPORT</th>
			<th>ID USER</th>
			<th>RATE</th>
			<th>ADDRESS</th>
			<th>MATCHTIME</th>
			<th></th>
			<th></th>
		</tr>
		<%
		for (MatchDTO f : list) {
		%>
		<tr>
			<td><a href=MatchServlet?mode=read&id=<%=f.getId()%>>
					<%=f.getIdSport()%>
			</a></td>
			<td><%=f.getIdUser()%></td>
			<td><%=f.getRate()%></td>
			<td><%=f.getAddress()%></td>
			<td><%=f.getMatchtime(1)%></td>
			<td><a href=MatchServlet?mode=read&update=true&id=<%=f.getId()%>>Edit</a>
			</td>
			<td><a href=MatchServlet?mode=delete&id=<%=f.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table> --%>

<%@ include file="../include/myMatchTable.jsp"%>



<form id="floatright" action="MatchServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="iduser">ID USER</label>
    </div>
    <div class="col-75">
      <input type="number" id="iduser" name="iduser" placeholder="inserisci id User">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="idsport">ID SPORT</label>
    </div>
    <div class="col-75">
      <input type="number" id="idsport" name="idsport" placeholder="inserisci id Sport">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="rate">RATE</label>
    </div>
    <div class="col-75">
      <input type="number" id="rate" name="rate" placeholder="inserisci rate"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="address">ADDRESS</label>
    </div>
    <div class="col-75">
      <input type="text" id="address" name="address" placeholder="inserisci address"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="matchtime">MATCHTIME</label>
    </div>
    <div class="col-75">
      <input type="text" id="matchtime" name="matchtime" placeholder="inserisci matchtime"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../include/joinMatchTable.jsp"%>
<br>
<%@ include file="../include/unjoinMatchTable.jsp"%>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>