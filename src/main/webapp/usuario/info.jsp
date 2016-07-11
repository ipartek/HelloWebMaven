<%@ include file="../includes/head.jsp" %>

<h1>Información Usuario</h1>

<%
	
	//Lo recogemos en  heas.jsp
	//Persona usuario= (Persona)session.getAttribute("usuario_logeado");
%>



<form method="post" action="#">


	<label for="nombre"> Nombre:</label>
	<input type="text" name="nombre" value="<%=p.getNombre() %>" ><br>
	
	
	<label for="ape1">Apellido1:</label>
	<input type="text" name="ap1" value="<%=p.getApellido1() %>" ><br>
		
	<label for="ape2">Nombre:</label>
	<input type="text" name="ape2" value="<%=p.getApellido2() %>" ><br>
	
	<label for="dni">DNI:       </label>
	<input type="text" name="dni" value="<%=p.getDni() %>" ><br>
	
	<label for="email">Email:</label>
	<input type="text" name="email" value="<%=p.getEmail() %>" ><br>
	
	<input type="submit" class="btn btn-primary" value="Guardar cambios" >

</form>

<%@ include file="../includes/footer.jsp" %>