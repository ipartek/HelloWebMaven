<%@ include file="../includes/head.jsp" %>

<h1>Listado Planetas</h1>
<% if (request.getAttribute("mensaje") != null){ 
 out.print("<div class='alert alert-info alert-dismissible'> <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
 out.print(request.getAttribute("mensaje"));
 out.print("</div>");

} %>

<form method="post" action="<%=Constantes.WEB_HOME%><%=Constantes.CONTROLLER_PLANETS%>">

	<input type="search" name="s" required placeholder="Buscar tu planeta en el universo">
	<input type="hidden" name="op" value="<%=Constantes.OP_SEARCH%>" >
	<button type="submit" > <i class="fa fa-search-plus" aria-hidden="true"> </i></button>

</form>
<br>
<table class="tabla">
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
				<td><img src="${p.imagen}" alt="${p.nombre}" /> </td>
				<td>${p.nombre} </td>
				<td><a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_DETAIL%>&id=${p.id}" ><i class="fa fa-eye" aria-hidden="true"> </i></a></td>
				<td><a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_DELETE%>&id=${p.id}" ><i class="fa fa-trash" aria-hidden="true"> </i></a></td>
			</tr>
		
		</c:forEach>
		
	</tbody>

</table>

<%@ include file="../includes/footer.jsp" %>