<%@ include file="../includes/head.jsp" %>

<h1>Información de usuario</h1>

<%
	//Lo recogemos en head
	//Persona usuario = (Persona)session.getAttribute("usuario_logeado");
%>

<form action="" method="post"
	name="Login_Form" class="form-signin">
	<h3 class="form-signin-heading">Datos Usuario</h3>
	<hr class="colorgraph">
	<br> 
		<label for="nombre">Nombre</label>
		<input type="text" class="form-control" name="nombre" value="<%=p.getNombre() %>" required="" autofocus="" />
		<!-- ${sessionScope.usuario_logeado.nombre} es lo mismo que p.getNombre()%> --> 
		<br>
		<label for="apellido1">Apellido1</label>
		<input	type="text" class="form-control" name="apellido1" placeholder="<%=p.getApellido1() %>" required="" />
		<br>
		<label for="apellido2">Apellido1</label>
		<input	type="text" class="form-control" name="apellido2" placeholder="<%=p.getApellido2() %>" required="" />
		<br>
		<label for="dni">Dni</label>
		<input	type="text" class="form-control" name="dni" placeholder="<%=p.getDni() %>" required="" />
		<br>
		<label for="email">Email</label>
		<input	type="text" class="form-control" name="email" placeholder="<%=p.getEmail() %>" required="" />
		<br>
		
		<br>
		<br>
		
		<button type="submit" class="btn btn-lg btn-primary btn-block" name="Submit"
		value="Guardar">Enviar</button>
	
</form>

<%@ include file="../includes/footer.jsp" %>