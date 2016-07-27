<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>



<%
	Persona pe = (Persona)request.getAttribute("detalle");
%>
<h1>Candidato <%=pe.getNombre()%></h1>

<%	
	if ( request.getAttribute("msg") != null ){
		out.print("<hr>");
		out.print(request.getAttribute("msg"));
		out.print("<hr>");
	}	
%>

<form action="<%=Constantes.CONTROLLER_PERSONAS%>" method="post">

	<label for="iddisabled">Id:</label>
	<input type="text" name="iddisabled" disabled value="<%=pe.getId()%>">
	<br>

	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" required value="<%=pe.getNombre()%>">
	<br>
	
	<label for="imagen">Email:</label>
	<input type="text" name="email" required value="<%=pe.getEmail()%>">
	<br>
	
	<input type="hidden" name="id" value="<%=pe.getId()%>">
	<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
	<input type="submit" value="Guardar">
	
</form>


<%@ include file="../includes/footer.jsp" %>