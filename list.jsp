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

<form action="<%=Constantes.CONTROLLER_PERSONAS%>"  method="post">
	<input type="search" name="s" required placeholder="Busca en el Universo">
	<input type="hidden" name="op" value="<%=Constantes.OP_SEARCH%>">	
	<input type="submit" value="Buscar">
</form>

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
				<td><img src="${p.imagen}" alt="${p.nombre}"/></td>
				<td>${p.nombre}</td>
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