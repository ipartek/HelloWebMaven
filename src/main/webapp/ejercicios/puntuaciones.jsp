<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp" %>

<h1>Puntuaciones</h1>

	<table border=1>
		<thead>
			<th style="width:40%">Usuario</th>
			<th style="width:35%">Juego</th>
			<th style="width:25%">Puntuación</th>
		</thead>
		<tbody>
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
<%@ include file="../includes/footer.jsp" %>