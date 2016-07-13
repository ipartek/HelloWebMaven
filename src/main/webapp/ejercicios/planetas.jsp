<%@page import="java.util.ArrayList"%>

<%@ include file="../includes/head.jsp" %>

     <div class="panel panel-danger">
        <div class="panel-heading"><h1 align="center"><i class="fa fa-star" aria-hidden="true"></i> Lista de Planetas <i class="fa fa-star" aria-hidden="true"></i>        </h1></div>
        <div class="panel-body">
        
        <table class="table table-striped table-hover">
	<thead class="thead-inverse">
		<th style="width:40%">Imagen</th>
		<th style="width:35%">Nombre</th>
		<th style="width:25%">Distancia</th>
	</thead>
	<tbody>
		<c:forEach var="p" items="${requestScope.Planetas }">

			<tr>
				<td><img src="${p.img}" width="75%"> </td>
				<td>${p.nombre}</td>
				<td>${p.distancia} años luz</td>
			</tr>
	</c:forEach>
	
</tbody>
</table>

</div>
</div>


<%@ include file="../includes/footer.jsp" %>