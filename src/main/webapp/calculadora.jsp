


<%@page import="com.ipartek.formacion.controller.CalculadoraServlet"%>
<%@page import="com.ipartek.formacion.Constantes"%>


<form method="post" action="<%=Constantes.WEB_HOME%>calculadora">

	<!-- donde Constantes.WEB_HOME = http://localhost:8080/HelloWebMaven/
	  por lo que  action=http://localhost:8080/HelloWebMaven/calculadora/ -->



	<label for="op1">Operador 1:&nbsp;&nbsp;&nbsp; </label>
		<input type="text" name="op1" required /> <br>
	
	<label for="op2">Operador 2:&nbsp;&nbsp;&nbsp; </label> 
		<input type="text" name="op2" required /><br>


	<!-- COMBO: El valor Sumar sera seleccionado inicialmente -->
	<label for="operacion">Operacion:&nbsp;&nbsp;&nbsp; </label>
		<select name="operacion">
			<option value="<%=CalculadoraServlet.SUMA%>" selected>Sumar</option>
			<option value="<%=CalculadoraServlet.RESTA%>" >Restar</option>
			<option value="<%=CalculadoraServlet.MULTIPLICA%>">Multiplicar</option>
			<option value="<%=CalculadoraServlet.DIVIDE%>">Dividir</option>
		</select><br>
		
	
	<label for="resultado">Resultado:&nbsp;&nbsp;&nbsp; </label>
		
	<%
		//recoger resultado
		request.getAttribute("resultado");
	%>
		
	<br><br>
	<input type="submit" value="Calcular" />
	
</form>	