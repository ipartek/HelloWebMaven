<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@ include file="../includes/head.jsp" %>

<%

	Planeta p = (Planeta)request.getAttribute("detail");

%>

<div class="panel panel-info">
	<div class="panel-heading">
		<h1 align="center">
			<i class="fa fa-star" aria-hidden="true"></i> Detalle ${requestScope.detail.nombre} <i class="fa fa-star" aria-hidden="true"></i>
		</h1>
	</div>
	
	<div class="panel-body">
		<div class="imgdetalle" id="planetas">

<%
	if (request.getAttribute("msg") != null){
		out.print("<div class='alert alert-warning' role='alert'>");
		out.print(request.getAttribute("msg"));
		out.print("</div>");
	}
%>

<img src="<%=p.getImg()%>" alt="<%=p.getNombre()%>" />
			
			<form method="post" action="<%=Constantes.CONTROLLER_PLANET %>">
				<table>
				<tr><td>
				<label for="iddisabled">Id:</label>
				<input type="text" name="iddisabled" disabled value="<%=p.getId()%>">
				</td></tr>
			
				<tr><td>
				<label for="nombre">Nombre:</label>
				<input type="text" name="nombre" required value="<%=p.getNombre()%>">
				</td></tr>
				
				<tr><td>
				<label for="img">URL Imagen:</label>
				<input id="urlimg" type="text" name="img" required value="<%=p.getImg()%>">
				</td></tr>
				
				<tr><td>
				<input type="hidden" name="id" value="<%=p.getId()%>">
				<input type="hidden" name="op" value="<%=Constantes.OP_SAVE%>">
				<input type="submit" class="btn btn-success" value="Guardar">
				</td><td><a href="<%=Constantes.CONTROLLER_PLANET %>?op=<%=Constantes.OP_LIST  %>"><input type="button" class="btn btn-danger" value="Cancelar"></a></td></tr>
				</table>
			</form>
			
			 
		</div>
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>