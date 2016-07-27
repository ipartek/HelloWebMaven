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
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" name=email value=<%=p.getEmail()%> required="" />
	      <br />
	      <button class="btn btn-lg btn-primary btn-block" type="submit" value="">Guardar Usuario</button>
    </form>
  </div>
<%@ include file="../includes/footer.jsp" %>