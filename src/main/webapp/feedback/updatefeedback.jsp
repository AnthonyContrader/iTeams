<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FeedbackDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="img/icona.png" />
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp" %>
<br>
<div class="main">

<%FeedbackDTO f = (FeedbackDTO) request.getAttribute("dto");%>





<form id="floatleft" action="Feedback/updatefeedback" <%=f.getId()%> method="post">
  <div class="row">
    <div class="col-25">
      <label for="iduser">id User</label>
    </div>
    <div class="col-75">
      <input type="text" id="iduser" name="iduser" value=<%=f.getIdUser()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idsport">id sport</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="idsport" name="idsport" value=<%=f.getIdSport()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idrate">rate</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="rate" name="rate" value=<%=f.getRate()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>