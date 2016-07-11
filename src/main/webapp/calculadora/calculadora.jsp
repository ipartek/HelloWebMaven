
<%@page import="com.ipartek.formacion.Constantes"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

	<!-- fontawesome -->
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">

	<!-- Enlaces a las hojas de Estilos propia -->
	<link rel="stylesheet" href="css/styles.css?v=2.0">

 	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

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