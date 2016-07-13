
<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="../includes/head.jsp"%>
  	

	<br><br><br>
	
	<h1>PUNTUACIONES</h1>
	<h2>JAVA</h2>
	<table class="table table-striped custab">
			<thead>
				<th id="encabezado" style="width:10%">ID</th>
				<th id="encabezado" style="width:30%">Usuario</th>
				<th id="encabezado" style="width:30%">Juego</th>
				<th id="encabezado" style="width:10%">Puntuacion</th>
			</thead>
	<tbody>
	<%
		ArrayList<Puntuacion> tabla = (ArrayList<Puntuacion>)request.getAttribute("tablaPuntuaciones"); 
		for(Puntuacion p : tabla){%>		 
				    <tr>
				      <th><%=p.getId()%></th>
				      <th><%=p.getNombreUsuario()%></th>
				      <th><%=p.getJuego()%></th>
				      <th><%=p.getPuntuacion()%></th>
				    </tr>			 
		<%}
	%>
	</tbody>
	</table>
	
	<hr>
	
	<h1>PUNTUACIONES</h1>
	<h2>JSTL</h2>
	<table class="table table-striped custab">		
	<tbody>	
		<c:forEach var="puntuacion" items="${requestScope.tablaPuntuaciones}">		 
				    <tr>
				      <td>${puntuacion.nombreUsuario}</td>
				      <td>${puntuacion.juego}</td>
				      <td>${puntuacion.puntuacion}</td>
				      <td>${puntuacion.id}</td>
				    </tr>
		</c:forEach>		 		    				 
	</tbody>
	</table>
	
		

<%@ include file="../includes/footer.jsp"%>