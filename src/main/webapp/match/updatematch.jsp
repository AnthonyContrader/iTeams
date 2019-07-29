<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MatchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  
  <a href="SportServlet?mode=sportlist">Sport</a>
  <a href="FeedbackServlet?mode=feedbacklist">Feedback</a>
  <a href="UserServlet?mode=userlist">User</a>
  <a class="active" href="MatchServlet?mode=matchlist">Match</a>
  
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%MatchDTO f = (MatchDTO) request.getAttribute("dto");%>


<form id="floatleft" action="MatchServlet?mode=update&id=<%=f.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="iduser">id User</label>
    </div>
    <div class="col-75">
      <input type="number" id="iduser" name="iduser" value=<%=f.getIdUser()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idsport">id sport</label>
    </div>
    <div class="col-75">
      <input
			type="number" id="idsport" name="idsport" value=<%=f.getIdSport()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idrate">rate</label>
    </div>
    <div class="col-75">
      <input
			type="number" id="rate" name="rate" value=<%=f.getRate()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="address">address</label>
    </div>
    <div class="col-75">
      <input type="text" id="address" name="address" value=<%=f.getAddress()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="matchtime">Matchtime</label>
    </div>
    <div class="col-75">
      <input type="text" id="matchtime" name="matchtime" value=<%=f.getMatchtime()%>>
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>