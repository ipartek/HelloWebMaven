
<%@page import="com.ipartek.formacion.Constantes"%>
<%@ include file="../includes/head.jsp" %>


<!doctype html>
<!-- tipo documento es HTML5 -->


<html lang="es">
<head>
<meta charset="utf-8">
<!-- juego de caracteres -->

<%
	Double resultado = (Double)request.getAttribute("resul");
	if (resultado==null){
		resultado = 0.0;
	}
%>

<div class="wrapper">
    <form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>calculadora">       
      <h2 class="form-signin-heading">Calculadora</h2>
      <input type="number" step="0.01" class="form-control" name=operador1 placeholder="operador1" required=""  autofocus="" />
      <input type="number" step="0.01" class="form-control" name="operador2" placeholder="operador2" required=""/>
      <select name="opcion">
	  	<option value="sumar">Sumar</option>
	  	<option value="restar">Restar</option>
	  	<option value="multiplicar">Multiplicar</option>
	  	<option value="dividir">Dividir</option>
	  </select><br />
	  <label name="resultado">Resultado:
	  <input type="number" step="0.01" class="form-control" name="resultado" value=<%=resultado%> disabled/>
	  </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit" value="">Calcular</button>
    </form>
  </div>
  
  <%@ include file="../includes/footer.jsp" %>