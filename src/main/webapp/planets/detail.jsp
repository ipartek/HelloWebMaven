<%@page import="com.ipartek.formacion.pojo.Planet"%>
<%@ include file="../includes/head.jsp" %>
<%
		
		if (request.getAttribute("msgMalo") != null) {
			%>
			<div class="alert alert-danger alert-dismissible fade in" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<%
			out.print(request.getAttribute("msgMalo"));
			 %>
			 </div>
			 <%
		}else if(request.getAttribute("msgBueno") != null){
			
			%>
			<div class="alert alert-success fade in" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<%
			out.print(request.getAttribute("msgBueno"));
			 %>
			 </div>
			 <%
		}
	%>
<%
	Planet pl = (Planet)request.getAttribute("detail");
	
%>	

<h1><%=pl.getNombre() %></h1>

<img src="<%=pl.getImagen()%>" width="100" height="100" alt="<%=pl.getNombre()%>"/>

<form action="<%=Constantes.CONTROLLER_PLANETS%>" method="post">

	<label for="iddisabled">Id:</label>
	<input type="text" name="iddisabled" disabled value="<%=pl.getId()%>">
	<br>
	
	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" required value="<%=pl.getNombre()%>">
	<br>
	
	<label for="imagen">URL Imagen:</label>
	<input type="text" name="imagen" required value="<%=pl.getImagen()%>">
	<br>
	
	<input type="hidden" name="id" value="<%=pl.getId()%>">
	<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
	<input type="submit" value="Guardar">
</form>
<%@ include file="../includes/footer.jsp" %>