<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.pojo.Puntuacion"%>
<%@ include file="../includes/head.jsp" %>


<div id="planetas" style="text-align:center">

	<h1>Planetas</h1>

<table class="table table-striped custab">
	<thead>
	</thead>
	<tbody>
			
		<c:forEach var="p" items="${requestScope.planetas}">
		<tr>
			<td align="left"><IMG SRC="${p.img}"></td>
			<td align="center">${p.nombre}<br> ${p.distancia} UA</td>
			
		</tr>	
		</c:forEach>	
		
	
	
	</tbody>
</table>


</div>


<%@ include file="../includes/footer.jsp" %>