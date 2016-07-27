<%@ include file="../includes/head.jsp" %>

<h1>Lista Personas</h1>
<%
		
		if (request.getAttribute("msgMalo") != null) {
			%>
			<div class="alert alert-danger alert-dismissible fade in" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<%
			out.print(request.getAttribute("msgMalo"));
			 %>
			 </div>
			 <%
		}else if(request.getAttribute("msgBueno") != null){
			
			%>
			<div class="alert alert-success fade in" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<%
			out.print(request.getAttribute("msgBueno"));
			 %>
			 </div>
			 <%
		}
	%>
	
<form action="<%=Constantes.CONTROLLER_PERSONAS%>" method="post">
	<input type="search" name="s" required placeholder="Busca Persona(s)">
	<input type="hidden"name="op" value="<%=Constantes.OP_SEARCH%>">
	<input type="submit" value="Buscar">
</form>
	
<br>

<a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_NEW%>" class="btn btn-default">Crear Nuevo</a>
<br>
<br>

<table id=personas class="tabla">

	<thead>
		<tr>
			<th>Nombre</th>
			<th>Email</th>
			<th>Ver</th>
			<th>Eliminar</th>
		</tr>
	</thead>	
	
	<tbody>
		<c:forEach var="pu" items="${requestScope.list}">
			<tr >
					<td>${pu.nombre}</td>
					<td>${pu.email}</td>
					<td><a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_DETAIL%>&id=${pu.id}"><i class="fa fa-eye" aria-hidden="true"></i></td>
					<td><a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_DELETE%>&id=${pu.id}"><i class="fa fa-trash" aria-hidden="true"></i></td>
					
			</tr>	
		</c:forEach>
	</tbody>
	
</table>


<%@ include file="../includes/footer.jsp" %>