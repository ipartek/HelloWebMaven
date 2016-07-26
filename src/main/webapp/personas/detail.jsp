<%@page import="com.ipartek.formacion.pojo.Person"%>
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
	Person pl = (Person)request.getAttribute("detail");
	
%>	

<h1><%=pl.getNombre() %></h1>



<form action="<%=Constantes.CONTROLLER_PERSONAS%>" method="post">

	<label for="iddisabled">Id:</label>
	<input type="text" name="iddisabled" disabled value="<%=pl.getId()%>">
	<br>
	
	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" required value="<%=pl.getNombre()%>">
	<br>
	
	<label for="imagen">URL Email:</label>
	<input type="text" name="email" required value="<%=pl.getEmail()%>">
	<br>
	
	<input type="hidden" name="id" value="<%=pl.getId()%>">
	<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
	<input type="submit" value="Guardar">
</form>


<%@ include file="../includes/footer.jsp" %>