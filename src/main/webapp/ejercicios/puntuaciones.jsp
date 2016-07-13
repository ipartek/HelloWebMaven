<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/head.jsp" %>
	<div class="wrapper">
		<h2 class="form-signin-heading">Puntuaciones</h2>
		<table border="1">
			<thead>
				<th style="width:40%">Usuario</th>
				<th style="width:35%">Juego</th>
				<th style="width:25%">Puntuación</th>
			</thead>
			<tbody>
				<!-- Escribimos una fila por cada objeto puntuación del ArrayList -->
				<%
					ArrayList<Puntuacion> lista = (ArrayList<Puntuacion>)request.getAttribute("tblPuntuaciones");
					for (Puntuacion p1 : lista ) { 
				%>
				<tr>
					<td><%=p1.getUsuario()%></td>
					<td><%=p1.getJuego() %></td>
					<td align="right"><%=p1.getPuntuacion() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
<%@ include file="../includes/footer.jsp" %>