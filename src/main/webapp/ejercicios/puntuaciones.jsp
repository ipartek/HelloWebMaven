<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.controlador.PuntuacionServlet"%>


<%@ include file="../includes/head.jsp"%>



<div id="puntuaciones">

	<h1 align="center">Mejores puntuaciones</h1>
	
    <table class="table table-striped custab">
    <thead>
        <tr>
            <th>Usuario</th>
            <th>Juego</th>
            <th>Puntuacion</th>
        </tr>
    </thead>
            <%
		ArrayList<Puntuacion> aPuntuaciones = (ArrayList<Puntuacion>)request.getAttribute("puntuaciones");
		for (Puntuacion puntos : aPuntuaciones){%>
				<tr id="puntuaciones">
					<td><%=puntos.getNombreUsuario()%></td>
					<td><%=puntos.getJuego() %></td>
					<td><%=puntos.getPuntuacion() %></td>
				</tr>	
		<%}%>
    </table>
 </div>
 <div id="puntuaciones2">
    <h1 align="center">Mejores puntuaciones</h1>
	
    <table class="table table-striped custab">
    <thead>
        <tr>
            <th>Usuario</th>
            <th>Juego</th>
           	<th>Puntuacion</th>
        </tr>
    </thead>
        <c:forEach var="pu" items="${requestScope.puntuaciones}">
				<tr >
					<td>${pu.nombreUsuario}</td>
					<td>${pu.juego}</td>
					<td>${pu.puntuacion}</td>
				</tr>	
		</c:forEach>
    </table>
</div>

<%@ include file="../includes/footer.jsp"%>


