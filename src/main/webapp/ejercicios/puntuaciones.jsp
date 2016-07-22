<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="com.ipartek.formacion.Constantes"%>


<%@ include file="../includes/head.jsp"%>

<br>
<br>
<br>

<div>
	<h1 class="mejores">Mejores puntuaciones</h1>

	<h2>Java</h2>

	<table class="users">
		<tbody>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Puntuacion</th>
				<th>Juego</th>
			</tr>

			<%ArrayList<Puntuacion> listaUsuario =(ArrayList<Puntuacion>) request.getAttribute("puntuaciones");
	for(Puntuacion puntos : listaUsuario){%>

			<tr>
				<td><%=puntos.getId()%></td>
				<td><%=puntos.getNombreUsuario()%></td>
				<td><%=puntos.getPuntuacion()%></td>
				<td><%=puntos.getJuego()%></td>

			</tr>
			<%} %>

		</tbody>

	</table>
	


	<h2>JSTL</h2>

	<table class="users">
		<tbody>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Puntuacion</th>
				<th>Juego</th>
			</tr>

			<c:forEach var="puntuacion" items="${requestScope.puntuaciones}">
				<tr>
					<td>${puntuacion.id}</td>
					<td>${puntuacion.nombreUsuario}</td>
					<td>${puntuacion.puntuacion}</td>
					<td>${puntuacion.juego}</td>


				</tr>
			</c:forEach>

		</tbody>

	</table>



</div>











<%@ include file="../includes/footer.jsp"%>