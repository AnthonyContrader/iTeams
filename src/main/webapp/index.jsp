
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<html>
<head>
<link rel="icon" type="image/png" href="img/icona.png" />


<link href="css/vittoriostyle.css" rel="stylesheet" >
<link href="css/iteams.css" rel="stylesheet" >
<title>Login SAMPLE</title>
</head>
<body>


	<div style="float: left;display: block;" class= "box">
		<img src="img/iTeams-02.svg"  alt="iTeams" id="logo"">

	</div>
<br>


	<div style="float: left;display: block;" class= "box">
		<form class="login" action="/User/login" method="post">

			<label for="user">Username:</label> <input type="text" id="user"
				name="username" placeholder="Insert username" required autofocus>  <label
				for="pass">Password: </label> <input type="password" id="pass"
				name="password" placeholder="Insert password" required>
				<input type = "text" name= "richiesta" value= "login" hidden>

			<button type="submit" value="login" name="pulsante">Login</button>
			<br>

			<button type="submit" name="pulsante">Register</button>

		</form>
	</div>
	







</body>
</html>