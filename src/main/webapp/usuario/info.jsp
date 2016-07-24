<%@ include file="../includes/head.jsp" %>

<h1>Información Usuario</h1>

<%
	
	//Lo recogemos en  head.jsp
	//Persona usuario= (Persona)session.getAttribute("usuario_logeado");
%>



<form method="post" action="#">


	<label for="nombre"> Nombre:</label>
	<input type="text" name="nombre" value="${sessionScope.usuario_logeado.nombre}" ><br>
	
	
	<label for="ape1">1º Apellido:</label>
	<input type="text" name="ape1" value="${sessionScope.usuario_logeado.apellido1}" ><br>
		
	<label for="ape2">2º Apellido:</label>
	<input type="text" name="ape2" value="${sessionScope.usuario_logeado.apellido2}" ><br>
	
	<label for="dni">DNI:       </label>
	<input type="text" name="dni" value="${sessionScope.usuario_logeado.dni}" ><br>
	
	<label for="email">Email:</label>
	<input type="text" name="email" value="${sessionScope.usuario_logeado.email}" ><br>
	
	<input type="submit" class="btn btn-primary" value="Guardar cambios" >

</form>

<%@ include file="../includes/footer.jsp" %>