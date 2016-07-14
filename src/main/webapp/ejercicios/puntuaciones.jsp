<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp" %>




		<% 
		ArrayList<Puntuacion> lPuntuacion = (ArrayList<Puntuacion>)request.getAttribute("tablaPuntuaciones");
		if (lPuntuacion!=null){
			for(Puntuacion e: lPuntuacion){
				%>
			<tr>
			<td><%=e.getNombreUsuario()%></td>
			<td><%=e.getJuego()%></td>
			<td align="right"><%=e.getPuntuacion()%></td>
			</tr>
				<%
			}
		}
		%>
		</tbody>
	</table>
	
	<hr>
	
	<h2>JSTL</h2>
	<table class="table table-striped custab">
		<thead>
			<th style="width:40%">Usuario</th>
			<th style="width:35%">Juego</th>
			<th style="width:25%">Puntuación</th>
		</thead>
		<tbody>
		
			<c:forEach var="puntuacion" items="${requestScope.tablaPuntuaciones}">
				<tr>
					<td>${puntuacion.nombreUsuario}</td>
					<td>${puntuacion.juego}</td>
					<td align="right">${puntuacion.puntuacion}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</div>
<%@ include file="../includes/footer.jsp" %>