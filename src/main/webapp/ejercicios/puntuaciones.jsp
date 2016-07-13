<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<table border="1">
		<thead>
		<th style="width:40%">Usuario</th>
		<th style="width:35%">Juego</th>
		<th style="width:25%">Puntuación</th>
		</thead>
		<tbody>
			<!-- Escribimos una fila por cada objeto puntuación del ArrayList -->
			<%
				ArrayList<Puntuacion> lista = (ArrayList)request.getAttribute("tblPuntuaciones");
				if (lista!=null){
					
			%>
			<tr>
				<%for (Puntuacion p : lista ) { %>
				<!-- Accedemos a las propiedades del objeto Puntuacion -->
				<!-- Internamente se esta llamando al método getNombreUsuario -->
				<td><%=p.getUsuario()%></td>
				<td><%=p.getJuego() %></td>
				<td align="right"><%=p.getPuntuacion() %></td>
				<% } %>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<br />
	<!-- Creamos un objeto Date con la fecha actual -->
	<%
		//java.util.Date date = new java.util.Date();
		//page.Context.setAttribute("date",date);
	%>
	
</body>
</html>