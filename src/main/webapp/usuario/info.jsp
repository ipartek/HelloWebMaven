<%@ include file="../includes/head.jsp" %>

<h1>Información del usuario</h1>

<!-- recuperar de session los datos y ponerlos en un formulario 
	Persona lo recogemos en head.jsp
--> 

<form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>usuario/info.jsp">

	<label for="nombre">Nombre: </label>
	<input type="text" name="nombre" value="${sessionScope.usuario_logeado.nombre}" required>
	<br><br>
	<label for="ape1">Apellido 1: </label>
	<input type="text" name="ape1" value="${sessionScope.usuario_logeado.apellido1}" required>
	<br><br>
	<label for="ape2">Apellido 2: </label>
	<input type="text" name="ape2" value="${sessionScope.usuario_logeado.apellido2}" required>
	<br><br>
	<label for="dni">DNI: </label>
	<input type="text" name="dni" value="${sessionScope.usuario_logeado.dni}" required>
	<br><br>
	<label for="email">Email: </label>
	<input type="email" name="email" value="${sessionScope.usuario_logeado.email}" required>
	<br><br>
	
	<button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>

</form>

<%@ include file="../includes/footer.jsp" %>