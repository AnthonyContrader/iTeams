<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
    <% if(session.getAttribute("utente").toString().toUpperCase().contains("ADMIN") ) {%>
  <a href="UserServlet?mode=userlist">Users</a>
  <% }%>
  <a class="active"  href="SportServlet?mode=sportlist">Sport</a>
  <a href="MatchServlet?mode=matchlist">Match</a>
  <a href="FeedbackServlet?mode=feedbacklist">Feedback</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>