<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SportDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="img/icona.png" />
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Sport</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/menu.jsp" %>
<br>
<div class="main">

<%SportDTO s = (SportDTO) request.getAttribute("dto");%>


<form id="floatleft" action="SportServlet?mode=update&id=<%=s.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Sport Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=s.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="players">Number of Players</label>
    </div>
    <div class="col-75">
      <input
			type="number" id="players" name="players" value=<%=s.getPlayers()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>