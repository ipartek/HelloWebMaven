<%@ include file="includes/head.jsp" %>
	<div class="navbar-example">
		<form action="<%= Constantes.WEB_HOME %>calculadora" method="POST">
			<h3><i class="fa fa-calculator" aria-hidden="true"></i> CALCULADORA</h3>
			<input type="text" name="operador1" placeholder="Introduce el 1º operador" required>
			<input type="text" name="operador2" placeholder="Introduce el 2º operador" required> 
			<select name="operacion">
				<option>SUMAR</option>
				<option>RESTAR</option>
				<option>MULTIPLICAR</option>
				<option>DIVIDIR</option>
			</select>
			<input type="submit" value="RESULTADO">
			<h4>RESULTADO = ${resultado}</h4>
			<h6 class="error">${error}</h6>
		</form>
	</div>
	<!--  Etiquetas para que se visualice a los usuarios -->
<%@ include file="includes/footer.jsp" %>