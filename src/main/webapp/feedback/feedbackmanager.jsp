<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.FeedbackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Feedback Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<%@ include file="../css/menu.jsp" %>

<div class="main">
	<%
		List<FeedbackDTO> list = (List<FeedbackDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>ID SPORT</th>
			<th>ID USER</th>
			<th>RATE</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (FeedbackDTO f : list) {
		%>
		<tr>
			<td><a href=FeedbackServlet?mode=read&id=<%=f.getId()%>>
					<%=f.getIdSport()%>
			</a></td>
			<td><%=f.getIdUser()%></td>
			<td><%=f.getRate()%></td>
			<td><a href=FeedbackServlet?mode=read&update=true&id=<%=f.getId()%>>Edit</a>
			</td>
			<td><a href=FeedbackServlet?mode=delete&id=<%=f.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="FeedbackServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="iduser">ID USER</label>
    </div>
    <div class="col-75">
      <input type="text" id="iduser" name="iduser" placeholder="inserisci id User">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="user">ID SPORT</label>
    </div>
    <div class="col-75">
      <input type="text" id="idsport" name="idsport" placeholder="inserisci id Sport">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">RATE</label>
    </div>
    <div class="col-75">
      <input type="text" id="rate" name="rate" placeholder="inserisci rate"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>