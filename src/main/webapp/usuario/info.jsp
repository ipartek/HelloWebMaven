<%@ include file="../includes/head.jsp" %>

<h1>Información Usuario</h1>

<%
	//Lo recogemos en head.jsp
	//Persona usuario = (Persona)session.getAttribute("usuario_logeado");
%>

<form action="#" method="post">
	
	
	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" value="<%=p.getNombre()%>">
	<br>
	
	<label for="ape1">1º Apellido:</label>
	<input type="text" name="ape1" value="<%=p.getApellido1()%>">
	<br>
	
	<label for="ape2">2º Apellido:</label>
	<input type="text" name="ape2" value="<%=p.getApellido2()%>">
	<br>
	
	<label for="dni">DNI:</label>
	<input type="text" name="dni" value="<%=p.getDni()%>">
	<br>
	
	<label for="email">Email:</label>
	<input type="text" name="email" value="<%=p.getEmail()%>">
	<br>
	<br>

	<input type="submit" class="btn btn-primary" svalue="Guardar Cambios">

</form>

<%@ include file="../includes/footer.jsp" %>