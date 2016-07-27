<%@ include file="../includes/head.jsp" %>

<h1>Listado Personas</h1>
<% if (request.getAttribute("mensaje") != null){ 
 out.print("<div class='alert alert-info alert-dismissible'> <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
 out.print(request.getAttribute("mensaje"));
 out.print("</div>");

} %>

<a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_NEW%>"><i class="fa fa-plus-square" aria-hidden="true"></i> Añadir Persona</a>
<br>
<br>


<table class="tabla">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Email</th>
			<th>Ver</th>
			<th>Eliminar</th>
		</tr>
	</thead>
	
	<tbody>
	

	
		<c:forEach var="p" items="${requestScope.list}">
	
			<tr>
				<td>${p.nombre}</td>
				<td>${p.email} </td>
				<td><a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_DETAIL%>&id=${p.id}" ><i class="fa fa-eye" aria-hidden="true"> </i></a></td>
				<td><a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_DELETE%>&id=${p.id}" onclick ="return confirmarEliminar('¿Está seguro que desea eliminar el registro?') "  ><i class="fa fa-trash" aria-hidden="true"> </i></a></td>
			</tr>
		
		</c:forEach>
		
		
		
	</tbody>

</table>

<%@ include file="../includes/footer.jsp" %>