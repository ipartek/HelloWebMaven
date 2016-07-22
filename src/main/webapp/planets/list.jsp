
<%@ include file="../includes/head.jsp"%>

<h1>Planetas</h1>


<%	
	if ( request.getAttribute("msg") != null ){
		out.print("<hr>");
		out.print(request.getAttribute("msg"));
		out.print("<hr>");
	}	
%>

<a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_NEW%>" class="btn btn-primary" role="button">Nuevo Planeta</a>

<form action="<%=Constantes.CONTROLLER_PLANETS%>"  method="post">
	<input type="search" name="s" required placeholder="Busca en el Universo">
	<input type="hidden" name="op" value="<%=Constantes.OP_SEARCH%>">	
	<input type="submit" value="Buscar">
</form>

<table class="tabla users">
	<thead>
		<tr>
			<th>Imagen</th>
			<th>Nombre</th>
			<th>Ver</th>
			<th>Eliminar</th>
		</tr>
	</thead>	
	
	<tbody>	
		<c:forEach var="p" items="${requestScope.list}">
			<tr>
				<td><img src="${p.imagen}" alt="${p.nombre}"/></td>
				<td>${p.nombre}</td>
				<td><a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_DETAIL%>&id=${p.id}">
						<span class="glyphicon glyphicon-eye-open tm"></span>
						</a>
				</td>
				<td>
					<a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_DELETE%>&id=${p.id}">
						<span class="glyphicon glyphicon-trash tm"></span>
					</a>	
				</td>
			</tr>
		</c:forEach>		
	</tbody>
</table>

<%@ include file="../includes/footer.jsp" %>











