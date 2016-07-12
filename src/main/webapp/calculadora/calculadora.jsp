<%@page import="com.ipartek.formacion.controller.CalculadoraServlet"%>
<%@ include file="../includes/head.jsp" %>
<div id="calculadora">		
	<h1>Calculadora</h1>

  		<form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>calculadora">
        
        	<label for="op1" >Operador 1: </label>
       		<input type="number" step="0.1" name="op1" placeholder="0,0" required />
       		<br><br>
       		<label for="op2">Operador 2: </label>
       		<input type="number" step="0.1" name="op2" placeholder="0,0" required />
       		<br><br>
       		<label for="operacion">Escoge una operación: </label>
       		<select name="operacion">
       			<option value="<%=CalculadoraServlet.SUMA%>">Sumar</option>
						<option value="<%=CalculadoraServlet.RESTA%>">Restar</option>
						<option value="<%=CalculadoraServlet.MULTIPLICA%>">Multiplicar</option>
						<option value="<%=CalculadoraServlet.DIVIDE%>">Dividir</option>
       		</select>
       		<br><br>
        	<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>	        
        
     	</form>
     	<div class="resultado">
     	<%
			
     		String calculo = (String) request.getAttribute("calculo");
			
			if (calculo!=null){
				out.print("<div class='alert alert-info alert-dismissible'> <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>"+ calculo + "</div>");
			}
		
		%>
		</div>
</div>
<%@ include file="../includes/footer.jsp" %>