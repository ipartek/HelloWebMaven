<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@ include file="../includes/head.jsp" %>

<%
	Planeta pl = (Planeta)request.getAttribute("detail");

	if (request.getAttribute("msg")!=null){
		out.print("<hr>");
		out.print(request.getAttribute("msg"));
		out.print("<hr>");
	}
%>

<h1>Detalle de <%=pl.getNombre()%></h1>

<img src="<%=pl.getImg()%>" alt="<%=pl.getNombre()%>" />

<form action="<%=Constantes.CONTROLLER_PLANETS%>" method="post">
	<label for="id">Id:</label>
	<input type="text" disabled name="iddisabled" value="<%=pl.getId()%>"><br />
	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" required value="<%=pl.getNombre()%>"><br />
	<label for="imagen">Imagen:</label>
	<input type="text" name="imagen" required value="<%=pl.getImg()%>"><br />
	<input type="hidden" name="id" value="<%=pl.getId()%>">
	<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
	<input type="submit" value="Guardar">
</form>

<%@ include file="../includes/footer.jsp" %>