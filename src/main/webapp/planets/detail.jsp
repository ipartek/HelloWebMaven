<%@ include file="../includes/head.jsp" %>

<div class="panel panel-info">
	<div class="panel-heading">
		<h1 align="center">
			<i class="fa fa-star" aria-hidden="true"></i> Detalle ${requestScope.detail.nombre} <i class="fa fa-star" aria-hidden="true"></i>
		</h1>
	</div>
	<div class="panel-body">
		<div id="planetas">

			<form method="post" action="<%=Constantes.CONTROLLER_PLANET %>?op=<%=Constantes.OP_UPDATE %>">

			<br>

			<table class="table table-striped table-hover">
				<thead class="thead-inverse">
					<tr>
						<th>Imagen</th>
						<th>Nombre</th>
						<th>Distancia</th>
					</tr>
				</thead>
				<tbody>

						<tr>
							<td id="urlimagen" ><img src="${requestScope.detail.img}" alt="${requestScope.detail.nombre}">
								<input type="url" name="img" placeholder="Url imagen" value="${requestScope.detail.img}"></td>
							<td><input type="text" name="nombre" placeholder="Nombre" value="${requestScope.detail.nombre}"></td>
							<td><input type="text" name="distancia" placeholder="Distancia" value="${requestScope.detail.distancia}"></td>
						</tr>

				</tbody>
			</table>
			<button type="submit">Modificar</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>