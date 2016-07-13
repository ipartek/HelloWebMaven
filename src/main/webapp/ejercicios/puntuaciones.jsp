<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp" %>

<div id="puntuaciones">

	<h1>Mejores Puntuaciones</h1>

	<table>
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

</div>

<%@ include file="../includes/footer.jsp" %>