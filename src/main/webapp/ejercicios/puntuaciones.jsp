<%@page import="com.ipartek.formacion.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="../includes/head.jsp" %>

     <div class="panel panel-danger">
        <div class="panel-heading"><h1><i class="fa fa-gamepad" aria-hidden="true"></i> Ranking de puntuaciones <i class="fa fa-gamepad" aria-hidden="true"></i>        </h1></div>
        <div class="panel-body">



<!-- Tabla en HTML  -->
<table class="table table-striped table-hover">
	<thead class="thead-inverse">
		<th style="width:40%">Usuario</th>
		<th style="width:35%">Juego</th>
		<th style="width:25%">Puntuacion</th>
	</thead>
	<tbody>
	
	<% 
		ArrayList<Puntuacion> lista = (ArrayList<Puntuacion>)request.getAttribute("tblPuntuaciones");
	   for ( Puntuacion p : lista ) {
	   		
	%>
	<tr>
		<td><%=p.getUsuario()%></td>
		<td><%=p.getJuego()%></td>
		<td><%=p.getPuntuacion()%></td>
	</tr>
	
	<% } //final del for %>
	
</tbody>
</table>

</div>
</div>


<%@ include file="../includes/footer.jsp" %>