<% String namem =  this.toString().toLowerCase();
String adminsess = session.getAttribute("usertype").toString().toLowerCase();
if(session.getAttribute("usertype").toString().toLowerCase().contains("user")){%>
<div class="navbar">
	<a <% if(namem.contains("home")){ %>class="active" <% } %> href="homeuser.jsp">Home</a> 
	<a <% if(namem.contains("sport")){ %>class="active" <% } %> href="SportServlet?mode=sportlist">Sport</a>
	<a <% if(namem.contains("match")){ %>class="active" <% } %> href="MatchServlet?mode=matchlist">Match</a>
	<a <% if(namem.contains("feedback")){ %>class="active" <% } %> href="FeedbackServlet?mode=feedbacklist">Feedback</a>
	<a	href="LogoutServlet" id="logout">Logout</a> 
	<a	href="UserServlet?mode=userlist" id="logout">Profile</a>
</div>
<%} else{%>

<div class="navbar">
	<a <% if(namem.contains("home")){ %>class="active" <% } %> href="homeadmin.jsp">Home</a> 
	<a <% if(namem.contains("user")){ %>class="active" <% } %> href="UserServlet?mode=userlist">User</a>
	<a <% if(namem.contains("sport")){ %>class="active" <% } %> href="SportServlet?mode=sportlist">Sport</a>
<%-- 	<a <% if(namem.contains("match")){ %>class="active" <% } %> href="MatchServlet?mode=matchlist">Match</a> --%>
	<a <% if(namem.contains("feedback")){ %>class="active" <% } %> href="FeedbackServlet?mode=feedbacklist">Feedback</a>
	<a	href="LogoutServlet" id="logout">Logout</a> 
<!-- 	<a	href="UserServlet?mode=userlist" id="logout">Profile</a> -->
</div>


	<%}%>