<%@page import="com.ipartek.formacion.Constantes"%>


<%@ include file="includes/head.jsp"%>
<br>



<!--form-->
<div class="form">
	<div class="avi">
		<h1>Login</h1>
	</div>
	<form method="post" action="<%=Constantes.WEB_HOME%>login">
		Usuario:<input type="text" name="usuario" required>
		Contrase&nacute;a:<input type="text" name="password" required>
		<input type="submit" value="Enviar" />
	</form>
</div>

<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
%>
<div class="alert alert-danger alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<%
		out.print(msg);
	%>
</div>
<%
	}
%>




<%@ include file="includes/footer.jsp"%>





