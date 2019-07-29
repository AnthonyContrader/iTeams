<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SportDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Sport</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="SportServlet?mode=sportlist">Sport</a>
  <a class="active" href="FeedbackServlet?mode=feedbacklist">Feedback</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%SportDTO s = (SportDTO) request.getAttribute("dto");%>


<form id="floatleft" action="SportServlet?mode=update&id=<%=s.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Nome Sport</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=s.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="players">Numero Giocatori</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="players" name="players" value=<%=s.getPlayers()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>