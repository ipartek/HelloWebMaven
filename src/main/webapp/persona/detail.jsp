<%@ include file="../includes/head.jsp" %>

<%

	Persona p = (Persona)request.getAttribute("detail");

%>

<div class="panel panel-danger">
	<div class="panel-heading">
		<h1 align="center">
			<i class="fa fa-user" aria-hidden="true"></i> Detalle de ${requestScope.detail.nombre} <i class="fa fa-user" aria-hidden="true"></i>
		</h1>
	</div>
	
	<div class="panel-body">
		<div class="imgdetalle" id="personas">

<%
	if (request.getAttribute("msg") != null){
		out.print("<div class='alert alert-warning' role='alert'>");
		out.print(request.getAttribute("msg"));
		out.print("</div>");
	}
%>

			
			<form method="post" action="<%=Constantes.CONTROLLER_PERSONA %>">
				<table>
				<tr><td>
				<label for="iddisabled">Id:</label>
				<input type="text" name="iddisabled" disabled value="<%=p.getId()%>">
				</td></tr>
			
				<tr><td>
				<label for="nombre">Nombre:</label>
				<input type="text" name="nombre" required value="<%=p.getNombre()%>">
				</td></tr>
				
				<tr><td>
				<label for="email">email:</label>
				<input type="text" name="email" required value="<%=p.getEmail()%>">
				</td></tr>
				
				<tr><td>
				<input type="hidden" name="id" value="<%=p.getId()%>">
				<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
				<input type="submit" class="btn btn-success" value="Guardar">
				</td><td><a href="<%=Constantes.CONTROLLER_PERSONA %>?op=<%=Constantes.OP_LIST  %>"><input type="button" class="btn btn-danger" value="Volver"></a></td></tr>
				</table>
			</form>
			
			 
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>