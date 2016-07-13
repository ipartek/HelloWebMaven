
<%@page import="com.ipartek.formacion.controller.CalculadoraServlet"%>
<%@page import="com.ipartek.formacion.Constantes"%>
	
<%@ include file="includes/head.jsp"%>

	<br><br><br><br>
	
	<div id="calculadora">

	<h1>Calculadora</h1>
	
	<form action="calcular" method="post">
	
		<input type="text" name="op1" value="" placeholder="0,0">
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
		
		<div class="resultado">
			${requestScope.calculo}
		</div>
	
		<input type="submit" value="calcular">
	</form>

	</div><!-- id calculadora -->

	
<%@ include file="includes/footer.jsp"%>	