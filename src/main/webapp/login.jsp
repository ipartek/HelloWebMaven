
<%@page import="com.ipartek.formacion.Constantes"%>

<%
	String msg = (String)request.getAttribute("msg");
	if (msg!=null){
		out.print(msg);
	}
%>

<form method="post" action="<%=Constantes.WEB_HOME%>login">
	<h1>Identifiquese para continuar</h1><br />
	<label for="usuario">Usuario:</label> 
	<input type="text" name="usuario" required><br /><br />
	
	<label for="password">Contraseña:</label> 
	<input type="text" name="password" required><br /><br />
	
	<input type="submit" value="Enviar" />
</form>