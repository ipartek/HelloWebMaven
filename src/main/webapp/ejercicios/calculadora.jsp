


<%@page import="com.ipartek.formacion.controller.CalculadoraServlet"%>
<%@page import="com.ipartek.formacion.Constantes"%>
<%@ include file="../includes/head.jsp" %>

<h1>Calculadora</h1>

<form method="post" action="calculadora">

	<!-- donde Constantes.WEB_HOME = http://localhost:8080/HelloWebMaven/
	  por lo que  action=http://localhost:8080/HelloWebMaven/calculadora/ -->



	<label for="op1">Operador 1:&nbsp;&nbsp;&nbsp; </label>
		<input type="number" step="0.1" name="op1" placeholder="0,0"> <br>
	
	<label for="op2">Operador 2:&nbsp;&nbsp;&nbsp; </label> 
		<input type="text"  name="op2" placeholder="0,0"><br>


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
		String resultado = (String)request.getAttribute("calculo");
		if ( resultado!=null){
			out.print(resultado);
		}
	%>
		
	<%
		//recoger resultado
		request.getAttribute("resul");
	%>
		
	<br><br>
	<input type="submit" value="calculadora" />
	
</form>	

<%@ include file="../includes/footer.jsp" %>