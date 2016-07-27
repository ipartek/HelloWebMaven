<%@ include file="../includes/head.jsp" %>

<h1>Personas</h1>


<%	
	if ( request.getAttribute("msg") != null ){
		out.print("<hr>");
		out.print(request.getAttribute("msg"));
		out.print("<hr>");
	}	
%>

<a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_NEW%>" class="btn btn-primary" role="button">Nueva Persona</a>

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
				<td>${p.email}</td>
				<td><a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_DETAIL%>&id=${p.id}"><i class="fa fa-eye" aria-hidden="true"></i></a></td>
				<td>
					<a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_DELETE%>&id=${p.id}">
						<i class="fa fa-trash" aria-hidden="true"></i>
					</a>	
				</td>
			</tr>
		</c:forEach>		
	</tbody>
</table>


<%@ include file="../includes/footer.jsp" %>