<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>



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
		<form class="login" action="LoginServlet" method="post">

			<label for="user">Username:</label> <input type="text" id="user"
				name="username" placeholder="Insert username"> <label
				for="pass">Password: </label> <input type="password" id="pass"
				name="password" placeholder="Insert password">

			<button type="submit" value="Login" name="pulsante">Login</button>
			<br>

			<button type="submit" name="register" value="register"
				name="pulsante">Register</button>

		</form>
	</div>
	







</body>
</html>