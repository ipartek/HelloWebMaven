<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp" %>

<h1>Lista de Planetas</h1>

<div class="wrapper">
		<table border="1">
			<thead>
				<th>Imagen</th>
				<th>Nombre</th>
				<th style="width:25%">Distancia respecto al Planeta Tierra</th>
			</thead>
			<tbody>
				<%
					ArrayList<Planeta> lista = (ArrayList<Planeta>)request.getAttribute("ListaPlanetas");
					for (Planeta p1 : lista ) { 
				%>
				<tr>
					<td><img src="<%=p1.getImg()%>" class="planetas"></img></td>
					<td><%=p1.getNombre()%></td>
					<td><%=p1.getDistancia()%></td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>

<%@ include file="../includes/footer.jsp" %>