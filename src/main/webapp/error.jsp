<%@ page isErrorPage="true"%>

<%@ include file="includes/head.jsp"%>	
	<br><br>
	<div id="errorPage">
	
		<br>
		Exception:
		<%=exception%>
		<br>
		Mensaje:
		<%=exception.getMessage()%>
	
	</div>
	
<%@ include file="includes/footer.jsp"%>	