<%@ include file="includes/head.jsp" %>
	<div class="navbar-example calculadora">
		<form action="<%= Constantes.WEB_HOME %>calculadora" method="POST">
			<h3><i class="fa fa-calculator" aria-hidden="true"></i> CALCULADORA</h3>
			<input type="text" name="operador1" placeholder="Introduce el 1º operador" required>
			<input type="text" name="operador2" placeholder="Introduce el 2º operador" required> 
			<select name="operacion">
				<option value="1">SUMAR</option>
				<option value="2">RESTAR</option>
				<option value="3">MULTIPLICAR</option>
				<option value="4">DIVIDIR</option>
			</select>
			<input type="submit" class="btn" value="RESULTADO">
			<% if (request.getAttribute("resultado") == null) { %>
			<h4>RESULTADO = 0.0</h4>
			<% } else { %>
			<h4>RESULTADO = ${resultado}</h4>
			<% }
			if (request.getAttribute("error") != null) { %>
			<h6 class="error">${ error }</h6>
			<% } %>
		</form>
	</div>
	<!--  Etiquetas para que se visualice a los usuarios -->
<%@ include file="includes/footer.jsp" %>