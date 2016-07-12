
<%@page import="com.ipartek.formacion.controller.CalculadoraServlet"%>
<%@ include file="../includes/head.jsp"%>

<%
	String calculo = (String)request.getAttribute("calculo");
	if (calculo==null){
		calculo="0,0";
	}
%>

<div class="wrapper">
	<form class="form-signin" method="post"
		action="<%=Constantes.WEB_HOME%>calculadora">
		<h2 class="form-signin-heading">Calculadora</h2>
		<input type="text" class="form-control" name=op1
			placeholder="0,00" required="" autofocus="" />
		<input type="text" class="form-control" name="op2"
			placeholder="0,0" required="" />
		<select name="operador">
			<option value="0">Sumar</option>
			<option value="1">Restar</option>
			<option value="2">Multiplicar</option>
			<option value="3">Dividir</option>
		</select><br />
		<label name="resultado">Resultado:
		<input type="text" class="form-control"
			name="resultado" value=<%=calculo%> disabled />
		</label>
		<button class="btn btn-lg btn-primary btn-block" type="submit"
			value="">Calcular</button>
	</form>
</div>

<%@ include file="../includes/footer.jsp"%>
