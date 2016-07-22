<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@ include file="../includes/head.jsp"%>



<%
	Planeta planeta = (Planeta)request.getAttribute("detail");
%>

<h1><%=planeta.getNombre()%></h1>

<img src="<%=planeta.getImagen()%>" alt="<%=planeta.getNombre()%>" />


<form  action="<%=Constantes.CONTROLLER_PLANETS%>" method="post">

	<label for="iddisabled">Id:</label>
	<input type="text" name="iddisabled" disabled value="<%=planeta.getId()%>">
	

	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" required value="<%=planeta.getNombre()%>">
	
	
	<label for="imagen">URL Imagen:</label>
	<input type="text" name="imagen" required value="<%=planeta.getImagen()%>">
	
	
	<input type="hidden" name="id" value="<%=planeta.getId()%>">
	<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
	<input type="submit" value="Guardar">
	
</form>





<%@ include file="../includes/footer.jsp"%>