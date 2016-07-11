<%@page import="com.ipartek.formacion.controller.CalculadoraServlet"%>
<%@ include file="../includes/head.jsp" %>

<h1>Calculadora</h1>

<form action="calcular" method="post">

	<input type="number" step="0.1" name="op1" value="" placeholder="0,0">
	<input type="text" name="op2" value="" placeholder="0,0">
	<br>
	<select name="op">
	  <option value="<%=CalculadoraServlet.SUMA%>">Suma</option>
	  <option value="<%=CalculadoraServlet.RESTA%>">Resta</option>
	  <option value="<%=CalculadoraServlet.MULTIPLICA%>">Multiplica</option>
	  <option value="<%=CalculadoraServlet.DIVIDE%>">Divide</option>
	</select>
	<br>
	<br>
	<%
		String calculo = (String)request.getAttribute("calculo");
		if ( calculo!=null){
			out.print(calculo);
		}
	%>

	<input type="submit" value="calcular">
</form>

<%@ include file="../includes/footer.jsp" %>
