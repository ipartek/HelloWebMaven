<%@page import="com.ipartek.formacion.Constantes"%>


<%
	String msg = (String)request.getAttribute("msg");
if ( msg != null ){
	out.print(msg);
}
%>

<form method="post" action="<%=Constantes.WEB_HOME %>login">

	<!-- donde Constantes.WEB_HOME = http://localhost:8080/HelloWebMaven/
	  por lo que  action=http://localhost:8080/HelloWebMaven/login/ -->

	<label for="usuario">Usuario:&nbsp;&nbsp;&nbsp;  </label>
	<input type="text" name="usuario" required />
	
	<br>
	<br>
	
	<label for="password">Password:</label>
	<input type="text" name="password" required />
	
	<br>
	
	<input type="submit" value="Enviar" />

</form>