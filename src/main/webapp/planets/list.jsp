<%@ include file="../includes/head.jsp"%>

<div class="panel panel-info">
	<div class="panel-heading">
		<h1 align="center">
			<i class="fa fa-star" aria-hidden="true"></i> Lista de Exoplanetas <i
				class="fa fa-star" aria-hidden="true"></i>
		</h1>
	</div>
	<div class="panel-body">

			
				<table>
					<tr><td align="left">
					<form method="post" action="<%=Constantes.CONTROLLER_PLANET %>">
						<input type="search" name="s" placeholder="Buscar planeta">
						<input type="hidden" name="op" value="<%=Constantes.OP_SEARCH%>">
						<input type="submit" value="Buscar">
					</form>
					</td>
					<td align="right">
					<form method="get" action="<%=Constantes.CONTROLLER_PLANET %>">				
						<input type="hidden" name="op" value="<%=Constantes.OP_NEW %>">
						<input type="submit" value="Nuevo planeta">
					</form>
					</td></tr>
				</table>
			</form>
		<div id="planetas">

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
						<th>Imagen</th>
						<th>Nombre</th>
						<th>Detalle</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${requestScope.list }">

						<tr>
							<td><img src="${p.img}" alt="${p.nombre}"></td>
							<td>${p.nombre}</td>
							<td><a href="<%=Constantes.CONTROLLER_PLANET%>?op=<%=Constantes.OP_DETAIL%>&id=${p.id}"><i class="fa fa-eye" aria-hidden="true"></i></a></td>
							<td><a href="<%=Constantes.CONTROLLER_PLANET%>?op=<%=Constantes.OP_DELETE%>&id=${p.id}"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>