<%@ include file="../includes/head.jsp" %>


<div id="planetas" style="text-align:center">

	<h1>Planetas</h1>

<table class="table table-striped custab">
	<thead>
	</thead>
	<tbody>
	
	<%
		ArrayList<Planeta> lista =  (ArrayList<Planeta>)request.getAttribute("planetas");
		for( Puntuacion p : lista ){
		
	%>
	<tr>
			<td aling="center"><%=p.getNombreUsuario()%></td>
			<td><%=p.getJuego()%></td>
			<td><%=p.getPuntuacion()%></td>
		</tr>		
	
	
	</tbody>


</div>


<%@ include file="../includes/footer.jsp" %>