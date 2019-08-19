<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.List"
import="it.contrader.dto.UserDTO" %>
<% String namem =  this.toString().toLowerCase();
UserDTO userDTO = (UserDTO)session.getAttribute("utenteCollegato");
if(userDTO.getUsertype().toString().toLowerCase().contains("user")){%>
<div class="navbar">
	<a <% if(namem.contains("home")){ %>class="active" <% } %> href="/homeuser.jsp">Home</a> 
	<a <% if(namem.contains("user")){ %>class="active" <% } %> href="../User/usermanager">User</a>
	<a <% if(namem.contains("sport")){ %>class="active" <% } %> href="../Sport/sportmanager">Sport</a>
	<a <% if(namem.contains("event")&&(!namem.contains("invite"))){ %>class="active" <% } %> href="../Event/eventmanager">Event</a>
	<a <% if(namem.contains("invite")){ %>class="active" <% } %> href="../Event/invitedevent">Invites</a>
	<a <% if(namem.contains("feedback")){ %>class="active" <% } %> href="../Feedback/feedbackmanager">Feedback</a>
	<a	href="/index.jsp" id="logout">Logout</a> 
	<a	href="../User/readuser" id="logout">Profile</a>
</div>
<%} else{%>

<div class="navbar">
	<a <% if(namem.contains("home")){ %>class="active" <% } %> href="/homeadmin.jsp">Home</a> 
	<a <% if(namem.contains("user")){ %>class="active" <% } %> href="../User/usermanager">User</a>
	<a <% if(namem.contains("sport")){ %>class="active" <% } %> href="../Sport/sportmanager">Sport</a>
 	<a <% if(namem.contains("event")){ %>class="active" <% } %> href= "../Event/eventmanager">Event</a>
	<a <% if(namem.contains("feedback")){ %>class="active" <% } %> href="../Feedback/feedbackmanager">Feedback</a>
	<a	href="/index.jsp" id="logout">Logout</a> 

</div>


	<%}%>