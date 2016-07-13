<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp"%>

<div id="puntuaciones">



	<div class="panel panel-success">
		<div class="panel-heading">
			<h1>
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				Ranking de puntuaciones <span class="glyphicon glyphicon-info"
					aria-hidden="true"></span>
			</h1>
		</div>
		<div class="panel-body">

			<table class="table table-striped custab">
				<thead>
					<th style="width: 40%">Usuario</th>
					<th style="width: 35%">Juego</th>
					<th style="width: 25%">Puntuacion</th>
				</thead>
				<tbody>
					<%
						ArrayList<Puntuacion> lista = (ArrayList<Puntuacion>) request.getAttribute("tblPuntuaciones");
						for (Puntuacion a : lista) {
					%>
					<tr>
						<td><%=a.getNombreUsuario()%></td>
						<td><%=a.getJuego()%></td>
						<td><%=a.getPuntuacion()%></td>
					</tr>

					<%
						} //end for
					%>
				</tbody>
			</table>

		</div>

		<h2>JSTL</h2>

		<div class="panel panel-success">
			<div class="panel-heading">
				<h1>
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					Ranking de puntuaciones <span class="glyphicon glyphicon-info"
						aria-hidden="true"></span>
				</h1>
			</div>
			<div class="panel-body">

				<table class="table table-striped custab">
					<tbody>
					
						<c:forEach var="a" items="${requestScope.tblPuntuaciones}">

							<tr>
								<td>${a.nombreUsuario}</td>
								<td>${a.juego}</td>
								<td>${a.puntuacion}</td>
							</tr>
						</c:forEach>



					</tbody>
				</table>


				<%@ include file="../includes/footer.jsp"%>