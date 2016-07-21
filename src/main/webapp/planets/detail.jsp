<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@ include file="../includes/head.jsp" %>

<%
	Planeta p = (Planeta)request.getAttribute("detail");

%>

<h1><%=p.getNombre()%></h1>


<img src="<%=p.getImagen()%>" alt="<%=p.getNombre()%>" />

<form action="<%=Constantes.CONTROLLER_PLANETS%>" method="post">

	<label for="iddisabled">Id:</label>
	<input type="text" name="iddisabled" disabled value="<%=p.getId()%>">
	<br>

	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" required value="<%=p.getNombre()%>">
	<br>
	
	<label for="imagen">URL Imagen:</label>
	<input type="text" name="imagen" required value="<%=p.getImagen()%>">
	<br>
	
	<input type="hidden" name="id" value="<%=p.getId()%>">
	<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
	<input type="submit" value="Guardar">
	
</form>


<%@ include file="../includes/footer.jsp" %>