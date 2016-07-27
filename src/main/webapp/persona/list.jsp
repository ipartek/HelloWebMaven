<%@ include file="../includes/head.jsp"%>

<div class="panel panel-danger">
	<div class="panel-heading">
		<h1 align="center">
			<i class="fa fa-user" aria-hidden="true"></i> Lista de Personas <i
				class="fa fa-user" aria-hidden="true"></i>
		</h1>
	</div>
	<div class="panel-body">

			
				<table>					
					<form method="get" action="<%=Constantes.CONTROLLER_PERSONA %>">				
						<input type="hidden" name="op" value="<%=Constantes.OP_NEW %>">
						<input type="submit" value="Nueva Persona">
					</form>
					</td></tr>
				</table>
			</form>
		<div id="personas">

			<br>

<%
	if (request.getAttribute("msg") != null){
		out.print("<div class='alert alert-warning' role='alert'>");
		out.print(request.getAttribute("msg"));
		out.print("</div>");
	}
%>

			<table class="table  table-striped table-hover datatabla">
				<thead class="thead-inverse">
					<tr>
						<th>Nombre</th>
						<th>Email</th>
						<th>Detalle</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${requestScope.list }">

						<tr>
							<td><b>${p.nombre}</b></td>
							<td>${p.email}</td>
							<td><a href="<%=Constantes.CONTROLLER_PERSONA%>?op=<%=Constantes.OP_DETAIL%>&id=${p.id}"><i class="fa fa-eye" aria-hidden="true"></i></a></td>
							<td><a href="<%=Constantes.CONTROLLER_PERSONA%>?op=<%=Constantes.OP_DELETE%>&id=${p.id}"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>