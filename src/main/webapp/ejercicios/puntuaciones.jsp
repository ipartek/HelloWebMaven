<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@ include file="../includes/head.jsp" %>


<div id="puntuaciones" style="text-align:center">

	<h1>Mejores Puntuaciones</h1>

	<table class="table table-striped custab">
	<thead>
		<th style="width:33%; text-align:center"><strong>Nombre Usuario</strong></th>
		<th style="width:33%; text-align:center"><strong>Juego</strong></th>
		<th style="width:33%; text-align:center"><strong>PuntuaciÃ³n</strong></th>
	</thead>
	<tbody>
	<%
		ArrayList<Puntuacion> lista =  (ArrayList<Puntuacion>)request.getAttribute("puntuaciones");
		for( Puntuacion p : lista ){
	%>
		<tr>
			<td aling="center"><%=p.getNombreUsuario()%></td>
			<td><%=p.getJuego()%></td>
			<td><%=p.getPuntuacion()%></td>
		</tr>		
		
	<% 		
		}//end for
	%>
	</tbody>
	</table>

<hr>

<!-- El mismo ejercicio con scriptles -->
<h2>JSTL</h2>

	<table class="table table-striped custab">
	<thead>
		<th style="width:33%; text-align:center"><strong>Nombre Usuario</strong></th>
		<th style="width:33%; text-align:center"><strong>Juego</strong></th>
		<th style="width:33%; text-align:center"><strong>Puntuación</strong></th>
	</thead>
	<tbody>
		<c:forEach var="p" items="${requestScope.puntuaciones}">
			<tr>
				<td>${p.nombreUsuario}</td>
				<td>${p.juego}</td>
				<td>${p.puntuacion}</td>
			</tr>		
		</c:forEach>
	
	</tbody>
	</table>



</div>

<%@ include file="../includes/footer.jsp" %>