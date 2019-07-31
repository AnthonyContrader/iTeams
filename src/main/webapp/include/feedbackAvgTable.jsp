			<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dao.FeedbackAvgDAO"
	import="it.contrader.dto.FeedbackAvgDTO"
	%>
	
			
			
			<%
			FeedbackAvgDAO faDAO = new FeedbackAvgDAO();
			List<FeedbackAvgDTO> listFADTO = faDAO.getAll();
			
			
			
		%>
	
	
	<h2>Feedback</h2>

	<br>
	
	<table>
		<tr>
			<th>Sport </th>
			<th>User</th>
			<th>Feedback</th>
		</tr>
		<%
			for (FeedbackAvgDTO f : listFADTO) {
		%>
		<tr>
			<td><%=f.getSportname()%></td>
			<td><%=f.getUsername()%></td>
			<td><%=f.getAverage()%></td>
			
		</tr>
		<%
			}
		%>
	</table>