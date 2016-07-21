<%@page import="com.ipartek.formacion.pojo.Planet"%>
<%@ include file="../includes/head.jsp" %>

<h1>Lista Planetas</h1>
<%
		
		if (request.getAttribute("msg") != null) {
			%>
			<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<%
			out.print(request.getAttribute("msg"));
			 %>
			 </div>
			 <%
		}
	%>
	
<form action="<%=Constantes.CONTROLLER_PLANETS%>" method="post">
	<input type="search" name="s" required placeholder="Busca tu Planeta en el Universo">
	<input type="hidden"name="op" value="<%=Constantes.OP_SEARCH%>">
	<input type="submit" value="Buscar">
</form>
	
<br>

<a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_NEW%>" class="btn btn-default">Crear Nuevo</a>
<br>
<br>

<table id=planetas class="tabla">

	<thead>
		<tr>
			<th>Imagen</th>
			<th>Nombre</th>
			<th>Ver</th>
			<th>Eliminar</th>
		</tr>
	</thead>	
	
	<tbody>
		<c:forEach var="pu" items="${requestScope.list}">
			<tr >
					<td><img src="${pu.imagen}" alt="${pu.nombre}"/></td>
					<td>${pu.nombre}</td>
					<td><a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_DETAIL%>&id=${pu.id}"><i class="fa fa-eye" aria-hidden="true"></i></td>
					<td><a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_DELETE%>&id=${pu.id}"><i class="fa fa-trash" aria-hidden="true"></i></td>
					
			</tr>	
		</c:forEach>
		
	</tbody>
</table>

<%@ include file="../includes/footer.jsp" %>