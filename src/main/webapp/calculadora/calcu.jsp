<%@page import="com.ipartek.formacion.controlador.CalculadoraServlet"%>
<%@page errorPage="error.jsp" %>
<%@ include file="../includes/head.jsp"%>




<form action="<%=Constantes.WEB_HOME%>calculadora" method="post"
	name="Login_Form" class="form-signin">
	<h3 class="form-signin-heading">Calculadora</h3>
	<hr class="colorgraph">
	<br> 
		<label for="numero1">Opción 1</label>
		<input type="text" step=0.1 class="form-control" name="numero1" placeholder="0,0" required="" autofocus="" /> 
		<br>
		<label for="numero2">Opción 2</label>
		<input	type="text" step=0.1 class="form-control" name="numero2" placeholder="0,0" required="" />
		<br>
		<label for="operadores">Operador</label> 
		<select id="operadores" name="operadores" >
			<option value="<%=CalculadoraServlet.SUMA%>">Sumar</option>
			<option value="<%=CalculadoraServlet.RESTA%>">Restar</option>
			<option value="<%=CalculadoraServlet.MULTIPLICA%>">Multiplicar</option>
			<option value="<%=CalculadoraServlet.DIVIDE%>">Dividir</option>
		</select>
		<br>
		<br>
		<%
				String resultado = String.valueOf(request.getAttribute("res"));
				if( resultado != null && resultado!="null"){
					out.print(resultado);
				}
				
						
		%>
		<!--<div class="resultado">${requestScope.res}</div> -->
		<br>
		<br>
	<button class="btn btn-lg btn-primary btn-block" name="Submit" action="calculadora"
		value="" type="submit">Calcular</button>
</form>

<%@ include file="../includes/footer.jsp"%>