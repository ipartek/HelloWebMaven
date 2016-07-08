<%@ include file="../includes/head.jsp"%>

<%
	String msg = (String)request.getAttribute("msg");
	if(msg != null){
		out.print(msg);
	}
%>


<form action="<%=Constantes.WEB_HOME%>calculadora" method="post"
	name="Login_Form" class="form-signin">
	<h3 class="form-signin-heading">Calculadora</h3>
	<hr class="colorgraph">
	<br> 
		<label for="numero1">Opción 1</label>
		<input type="text" class="form-control" name="numero1" placeholder="Number1" required="" autofocus="" /> 
		<br>
		<label for="numero2">Opción 2</label>
		<input	type="text" class="form-control" name="numero2" placeholder="Number2" required="" />
		<br>
		<label for="operadores">Operador</label> 
		<select name="operadores" >
			<option value="sumar">Sumar</option>
			<option value="restar">Restar</option>
			<option value="multiplicar">Multiplicar</option>
			<option value="dividir">Dividir</option>
		</select>
		<br>
		<br>
		
	<button class="btn btn-lg btn-primary btn-block" name="Submit"
		value="" type="Submit">Calcular</button>
</form>

<%@ include file="../includes/footer.jsp"%>