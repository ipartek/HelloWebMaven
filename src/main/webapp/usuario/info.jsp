<%@ include file="../includes/head.jsp" %>



<!-- recuperar de Session los datos y ponerlos en un Formulario -->

<%
	//Sobra porque lo recojemos en el head
	//Persona usuario = (Persona)session.getAttribute("usuario_logeado");
%>

<div class="wrapper">
    <form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>info.jsp">
    	<h1>Información Usuario</h1>
    	  <label for="nombre">Nombre:</label>
	      <input type="text" class="form-control" name=nombre value=<%=p.getNombre()%> required="" />
	      <label for="ape1">Apellido1:</label>
	      <input type="text" class="form-control" name=ape1 value=<%=p.getApellido1()%> required="" />
	      <label for="ape2">Apellido2:</label>
	      <input type="text" class="form-control" name=ape2 value=<%=p.getApellido2()%> required="" />
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" name=email value=<%=p.getEmail()%> required="" />
	      <label for="email">Dni:</label>
	      <input type="text" class="form-control" name=dni value=<%=p.getDni()%> required="" />
	      <br />
	      <button class="btn btn-lg btn-primary btn-block" type="submit" value="">Guardar Usuario</button>
    </form>
  </div>
<%@ include file="../includes/footer.jsp" %>