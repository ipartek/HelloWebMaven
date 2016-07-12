<%@ include file="../includes/head.jsp" %>

<h1>Información del usuario</h1>

<!-- recuperar de session los datos y ponerlos en un formulario 
	Persona lo recogemos en head.jsp
--> 


<form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>usuario/info.jsp">

	<label for="nombre">Nombre: </label>
	<input type="text" name="nombre" value="<%=p.getNombre()%>" required>
	<br><br>
	<label for="ape1">Apellido 1: </label>
	<input type="text" name="ape1" value="<%=p.getApellido1()%>" required>
	<br><br>
	<label for="ape2">Apellido 2: </label>
	<input type="text" name="ape2" value="<%=p.getApellido2()%>" required>
	<br><br>
	<label for="dni">DNI: </label>
	<input type="text" name="dni" value="<%=p.getDni()%>" required>
	<br><br>
	<label for="email">Email: </label>
	<input type="email" name="email" value="<%=p.getEmail()%>" required>
	<br><br>
	
	<button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>

</form>

<%@ include file="../includes/footer.jsp" %>