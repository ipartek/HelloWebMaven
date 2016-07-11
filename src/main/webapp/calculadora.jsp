<%@page import="com.ipartek.formacion.Constantes"%>
	
<%@ include file="includes/head.jsp"%>
<%

	String div = request.getParameter("resul");
%>
	<br><br>
	<form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>calculadora.jsp">
			<h1 class="form-signin-heading">CALCULATOR</h1>
				<br><br>
			<input type="number" class="form-control" name="valor1" required="" autofocus="" />
				<br><br>
			<input type="number" class="form-control" name="valor2" required="" />
				<br><br>
			<select name="select" class="form-control">
			  <option name="suma">Sumar</option>
			  <option name="resta">Restar</option>
			  <option name="division">Dividir</option>
			  <option name="multiplicacion">Multiplicar</option>
			</select>
				<br><br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">OPERA</button>
				<br><br>
			<label>Resultado -></label>&nbsp;&nbsp;<%=div %>
	</form>
	
	
<%@ include file="includes/footer.jsp"%>	