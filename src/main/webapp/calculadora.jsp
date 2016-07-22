<%@page import="com.ipartek.formacion.controller.CalculadoraServlet"%>
<%@page import="com.ipartek.formacion.Constantes"%>


<%@ include file="includes/head.jsp"%>
<br>



<!--form-->
<div class="calculadora">
	<div class="calch1">
		<h1>Calculadora</h1>
	</div>
	<form method="post" action="<%=Constantes.WEB_HOME%>calculadora">
		Introduzca el valor 1<input type="number" name="valor1" value="" placeholder="0,0" required> 
		Introduzca el valor 2<input type="number" name="valor2" value="" placeholder="0,0" required> 
		<br>
		Eliga el tipo de operacion:<select name="operacion" required>
			<option value="<%=CalculadoraServlet.SUMA%>">Sumar</option>
			<option value="<%=CalculadoraServlet.RESTA%>">Restar</option>
			<option value="<%=CalculadoraServlet.MULTIPLICA%>">Multiplicar</option>
			<option value="<%=CalculadoraServlet.DIVIDE%>">Dividir</option>
		</select> <br><input type="submit" value="Calcular" />
		
		<br>

		<div class="resultado">
			<%
		String calculo = (String)request.getAttribute("calculo");
		if ( calculo!=null){
			out.print(calculo);
		}
	%>
		</div>


	</form>
</div>






<%@ include file="includes/footer.jsp"%>