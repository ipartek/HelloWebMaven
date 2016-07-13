<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp" %>

<div id="puntuaciones">

	<h1>Mejores Puntuaciones</h1>

	<h2>JAVA</h2>
	<table class="table table-striped custab">
	<tbody>
	<%
		ArrayList<Puntuacion> lista =  (ArrayList<Puntuacion>)request.getAttribute("puntuaciones");
		for( Puntuacion p : lista ){
	%>
		<tr>
			<td><%=p.getUsuario()%></td>
			<td><%=p.getJuego()%></td>
			<td><%=p.getPuntuacion()%></td>
		</tr>		
		
	<% 		
		}//end for
	%>
	</tbody>
	</table>

	<hr>

	<h2>JSTL</h2>
	<table class="table table-striped custab">
	<tbody>		
		<c:forEach var="p" items="${requestScope.puntuaciones}">
			<tr>
				<td>${p.usuario}</td>
				<td>${p.juego}</td>
				<td>${p.puntuacion}</td>
			</tr>
		</c:forEach>				
	</tbody>
	</table>

</div>

<%@ include file="../includes/footer.jsp" %>