<%@page import="com.ipartek.formacion.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="../includes/head.jsp" %>

     <div class="panel panel-success">
        <div class="panel-heading"><h1><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Ranking de puntuaciones <span class="glyphicon glyphicon-info" aria-hidden="true"></span></h1></div>
        <div class="panel-body">



<!-- Tabla en HTML  -->
<table>
	<% int i= 0;
		ArrayList<Puntuacion> lista = (ArrayList<Puntuacion>)request.getAttribute("tblPuntuaciones");
	   for ( Puntuacion p : lista ) {
	   		i++;
	%>
<tr>

			<td>${requestScope.tblPuntuaciones.usuario}</td>
			<td>${requestScope.tblPuntuaciones.juego}</td>
			<td>${requestScope.tblPuntuaciones.puntuacion}</td>
</tr>
	
	<% } //final del for %>

</table>

</div>
</div>


<%@ include file="../includes/footer.jsp" %>





<form method="post" action="<%=Constantes.WEB_HOME %>ranking" class="form-signin">
       	
     <input type="text" name="op1" class="form-control" placeholder="Operando 1" value="${requestScope.puntos}">
       
        <button class="btn btn-lg btn-primary btn-block" type="submit">RANKING</button>
      </form>