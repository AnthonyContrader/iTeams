<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dao.UserRepository"
	import="it.contrader.services.UserService"
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link rel="icon" type="image/png" href="img/icona.png" />
<link href="css/vittoriostyle.css" rel="stylesheet">


<%--<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>

</head>
<body>





<%@include file="css/menu.jsp"%>




	<div class="main">




		<h1>Welcome <%=session.getAttribute("utente")%></h1>
		
		<br>
		
		<!-- <h3>
			iTeams si basa su un sistema di feedback per organizzare squadre
			bilanciate per i tuoi sport preferiti.<br> Iscriviti e scegli i
			tuoi sport preferiti.<br> iTeams ti inviera' automaticamente
			degli inviti in base ai tornei organizzati nella tua citta'.<br>
			Dopo ogni partita dai un voto agli altri giocatori.<br>
		</h3> -->


<div class="row">
   <div class="col-md-2 col-lg-2 col-sm-3 col-xs-1"></div>
        <div style="float:left;" class="col-md-8 col-lg-8 col-sm-6 col-xs-10">

		
				
		
		</div>



	</div>
	
	<div class="col-md-2 col-lg-2 col-sm-3 col-xs-1"></div>
	
	
	</div>
	
		
	


	<%@ include file="css/footer.jsp"%>

</body>
</html>