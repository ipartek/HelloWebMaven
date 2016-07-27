<%@ include file="../includes/head.jsp" %>

<%
	Persona p = (Persona)request.getAttribute("persona");
	
	if (request.getAttribute("mensaje") != null){ 
		 out.print("<div class='alert alert-info alert-dismissible'> <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
		 out.print(request.getAttribute("mensaje"));
		 out.print("</div>");
		
	}
%>
	
<h1><%=p.getNombre() %></h1>



<form action="<%=Constantes.CONTROLLER_PERSONAS%>" method="post">

	<label for="iddisabled">Id: </label>
	<input type="text" name="iddisabled" disabled value="<%=p.getId()%>">
	<br>

	<label for="nombe">Nombre: </label>
	<input type="text" name="nombre" required value="<%=p.getNombre()%>">
	<br>
	
	<label for="email">Email: </label>
	<input type="email" name="email" required value="<%=p.getEmail()%>">
	<br>
	
	<input type="hidden" name="id" value="<%=p.getId()%>">
	<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
	
	<input type="submit" value="Guardar">
</form>


<%@ include file="../includes/footer.jsp" %>