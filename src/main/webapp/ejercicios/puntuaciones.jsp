<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.controlador.PuntuacionServlet"%>


<%@ include file="../includes/head.jsp"%>




	<ol>
		<%
		ArrayList<Puntuacion> aPuntuaciones = (ArrayList<Puntuacion>)request.getAttribute("puntuaciones");
		for (Puntuacion puntos : aPuntuaciones){%>
			
			
			
					<li><%=puntos.getNombreUsuario()%></li>
						
			
			
		<%}%>
	</ol>





