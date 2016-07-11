<%@ include file="../includes/head.jsp"%>


<form action="#" method="post" class="form-signin">
	<h3 class="form-signin-heading">Información del Usuario</h3>

	<%
		Persona usuario = (Persona) session.getAttribute("usuario_logeado");
		if (usuario != null) {
	%>
			
	<label for="nombre" >Nombre: </label>
	<input type="text" name="ape1" class="form-control" placeholder="Apellido 1" value="<%=usuario.getNombre() %>"><br>
	
	<label for="ape1">Apellido 1:</label>
	<input type="text" name="ape1" class="form-control" placeholder="Apellido 1" value="<%=usuario.getApellido1() %>"><br>
	
	<label for="ape2">Apellido 2:</label>
	<input type="text" name="ape2" class="form-control" placeholder="Apellido 2" value="<%=usuario.getApellido2() %>"><br>
	
	<label for="dni">DNI:</label>
	<input type="text" name="dni" class="form-control" placeholder="DNI" value="<%=usuario.getDni() %>"><br>
	
	<label for="email">Email:</label>
	<input type="text" name="email" class="form-control" placeholder="email" value="<%=usuario.getEmail() %>">
	



<%

		
		}
	%>

<br><button class="btn btn-lg btn-danger btn-block" type="submit">Guardar cambios</button>
</form>

<%@ include file="../includes/footer.jsp"%>