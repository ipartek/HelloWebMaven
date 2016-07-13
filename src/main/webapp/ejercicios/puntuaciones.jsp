
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp"%>

	<br><br><br>
	<%
		ArrayList tabla = (ArrayList)request.getAttribute("tablaPuntuaciones"); 
	%>

	<div>
	
	<%=tabla%>
	
	
	
	</div>


<%@ include file="../includes/footer.jsp"%>