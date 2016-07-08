
<%@page import="com.ipartek.formacion.Constantes"%>


<%
 	String msg = (String)request.getAttribute("msg");
 	if ( msg != null ){
 		out.print(msg);
 	}
 %>
 
<form method = "post" action="<%=Constantes.WEB_HOME%>login">

<label for=""usuario">Usuario:</label>

<input type = "text" name = "usuario" required>
<br>
<br>

<label for=""password">Password:</label>


<input type = "text" name = "password" required>

<br>
<br>
<br>



<input type = "submit"  value= "Enviar"/>
</form>