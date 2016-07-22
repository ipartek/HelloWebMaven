
<%@ include file="../includes/head.jsp" %>

	
	<br><br><br>
	
	<form action="<%=Constantes.CONTROLLER_PLANETS%>" method="post">
		<input type="search" name="search" required placeholder="Buscar planeta en todo el universo">
		<input type="hidden" name="op" value="<%=Constantes.OP_SEARCH%>">
		<input type="submit" value="Buscar">
	</form>
	
	<br>
	<a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_NEW%>">Nuevo Planeta</a>
	
	<table class="tabla" border = "1">
	
		<thead>
			<tr>
				<th>Imagen</th>
				<th>Nombre</th>
				<th>Detail</th>
				<th>Delete</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="p" items="${requestScope.list}">		 
					    <tr>
					      	<td><img src="${p.img}" alt="${p.nombre}"/></td>
					      	<td>${p.nombre}</td>
					      	<td>
					      		<a href ="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_DETAIL%>&id=${p.id}">
					      		<i class="fa fa-eye hp" aria-hidden="true"></i></a>
					      	</td>
							<td>
								<a href ="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_DELETE%>&id=${p.id}">
								<i class="fa fa-trash hp" aria-hidden="true"></i></a>
							</td>
							
					    </tr>
			</c:forEach>		 		    		
		</tbody>
	</table>
	
	<%
		if(request.getAttribute("msg") != null){
			out.print("<hr>");
			out.print(request.getAttribute("msg"));
			out.print("<hr>");
		}
	
	%>

<%@ include file="../includes/footer.jsp" %>