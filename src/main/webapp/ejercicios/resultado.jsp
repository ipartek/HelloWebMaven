<%@page import="com.ipartek.formacion.controller.EjercicioServlet"%>
<%@ include file="../includes/head.jsp" %>


	<%
		int tipo = (Integer)request.getAttribute("tipoEnvio") ;
		switch (tipo) {
			case EjercicioServlet.TIPO_GET:
	%>

	<!-- Presentar por pantalla los parámetros obtenidos por GET -->
	<h2>Parametros por GET</h2>

		<div class="misaludo">Saludo = <%=request.getAttribute("saludo")%></div>
		<br>
		<div class="midespedida">Despedida = <%=request.getAttribute("despedida")%></div>
		<hr>
		
		
	<% 
		break;
		case EjercicioServlet.TIPO_POST: 
	%>
	<!-- --------------------------------------------------------------------------- -->	
	<!-- Presentar por pantalla los parámetros obtenidos por POST -->
	<h2>Parametros por POST</h2>
	
	<table class="table table-striped custab">
	  <tr>
	    <th>Nombre Atributo</th>
	    <th>Valor Atributo</th>
	  </tr>
	  <tr>
	    <td><%out.print(request.getAttribute("resultadoPost1"));%></td>
	    <td><%out.print(request.getAttribute("resultadoPost2"));%></td>
	  </tr>
	</table>
	
	<!-- --------------------------------------------------------------------------- -->	
	<!-- Presentar por pantalla los parámetros obtenidos por POST con scriptles -->
	<h2>Parametros por POST con scriptles</h2>


	<table class="table table-striped custab">
	  <tr>
	    <th>Nombre Atributo</th>
	    <th>Valor Atributo</th>
	  </tr>
	  <tr>
	    <td>${requestScope.resultadoPost1}</td>
	    <td>${requestScope.resultadoPost2}</td>
	  </tr>
	</table>

	<% 
		break;
		default:
			out.print("No me has enviado nada");
		} //fin switch
	
	%>


<%@ include file="../includes/footer.jsp" %>