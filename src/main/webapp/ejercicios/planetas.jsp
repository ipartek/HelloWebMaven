
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@ include file="../includes/head.jsp"%>
  	
<br><br><br>
	<table class="table">
				<thead>
					<th id="encabezado" style="width:34%">Imagen</th>
					<th id="encabezado" style="width:33%">Nombre</th>
					<th id="encabezado" style="width:33%">Distancia del Sol</th>
				</thead>
		<tbody>
	 <%
			ArrayList<Planeta> listaPlanetas = (ArrayList<Planeta>)request.getAttribute("lista"); 
			for(Planeta p : listaPlanetas){%>		 
					    <tr>
					      <th><img id="planet" src="<%=p.img%>"></th>
					      <th><%=p.nombre%></th>
					      <th><%=p.distancia%></th>
					    </tr>			 
			<%}
		%> 
		
		</tbody>
	</table>	
	  	


<%@ include file="../includes/footer.jsp"%>  	