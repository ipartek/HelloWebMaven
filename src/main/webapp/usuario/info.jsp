<%@ include file="../includes/head.jsp" %>



<!-- recuperar de Session los datos y ponerlos en un Formulario -->

<div class="wrapper">
    <form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>info.jsp">
    	<h1>Información Usuario</h1>
      <%
	String msg = (String)request.getAttribute("msg");
	if (msg!=null){
		%><div class="alert alert-danger" role="alert"><%=msg%>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;
		</div><%
	}
%>
      Nombre:<input type="text" class="form-control" name=usuario value=<%=p.getNombre()%> required="" />
      Apellido1:<input type="text" class="form-control" name=usuario value=<%=p.getApellido1()%> required="" />
      Apellido2:<input type="text" class="form-control" name=usuario value=<%=p.getApellido2()%> required="" />
      Email:<input type="text" class="form-control" name=usuario value=<%=p.getEmail()%> required="" />
      Dni:<input type="text" class="form-control" name=usuario value=<%=p.getDni()%> required="" />
      <br />    
      <button class="btn btn-lg btn-primary btn-block" type="submit" value="">Modificar Usuario</button>
    </form>
  </div>
<%@ include file="../includes/footer.jsp" %>