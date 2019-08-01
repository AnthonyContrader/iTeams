
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>

<head>

<link href="css/vittoriostyle.css" rel="stylesheet">

<title>User Registration</title>

</head>

<body>

	<form class= "login" action="RegisterServlet"  method="post">
	
		<br>
				<label for= "name"> Name: </label> 
				
				<input type="text" name="userName" placeholder= "Insert username" />
		 
		<br>
		 		<label for= "pass"> Password: </label>
		 		
		 		<input type="password" name="userPass" placeholder= "Insert password" />		 		
		
		<br>
		
		
		<button type="submit" name="register" value="register" name="pulsante">Register</button>
		<button type="submit" name="register" value="back" name="pulsante">Back</button>
		
	</form>
	
</body>
</html>
