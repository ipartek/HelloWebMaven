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
	<input type="submit" value="Enviar"/>
	</form>
</div>

<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
%>
<h1>
	<div class="alert alert-danger" role="alert"><%=msg%>
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</h1>
<%} %>


<%@ include file="includes/footer.jsp"%>






<!--   <form method="post" action="<%=Constantes.WEB_HOME%>login">

	Usuario:<input type="text" name="usuario" required><br><br>
	Contraseña:<input type="text" name="contraseña" required>
	<input type="submit" value="enviar"/>
	



</form>-->