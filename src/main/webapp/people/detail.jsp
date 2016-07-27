<!-- DETALLE PERSONA -->
<%@page import="com.ipartek.formacion.pojo.Persona"%>
<%@ include file="../includes/head.jsp" %>

<%
Persona p = (Persona)request.getAttribute("detail");

%>

<h1><%=p.getNombre()%></h1>

<%	
	if ( request.getAttribute("msg") != null ){
		out.print("<hr>");
		out.print(request.getAttribute("msg"));
		out.print("<hr>");
	}	
%>





<form action="<%=Constantes.CONTROLLER_PEOPLE%>" method="post">

	<label for="iddisabled">Id:</label>
	<input type="text" name="iddisabled" disabled value="<%=p.getId()%>">
	<br>

	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" required value="<%=p.getNombre()%>">
	<br>	
	
	<label for="nombre">Email:</label>
	<input type="text" name="email" required value="<%=p.getEmail()%>">
	<br>
	
	
	<input type="hidden" name="id" value="<%=p.getId()%>">
	<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
	<input type="submit" value="Guardar">
	
</form>


<%@ include file="../includes/footer.jsp" %>