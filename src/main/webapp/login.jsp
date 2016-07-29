<%@page import="com.ipartek.formacion.Constantes"%>

<!-- Importamos los TAG de JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="idioma" value="${not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES'}" scope="session" />
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="i18nmesages" /> 


<!DOCTYPE html>
<html lang="${idioma}">
<head>
<meta charset="utf-8">
<!-- juego de caracteres -->
<title>Hello Web | Login </title>
<!-- titulo de la pagina-pestaña -->

<base href="<%=Constantes.WEB_HOME%>">
<meta name="description" content="App Web con JEE">
<meta name="author" content="Ipartek Formacion SL">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
	
	<!-- Enlaces a las hojas de Estilos propia -->
	<link rel="stylesheet" href="css/formLogin.css">
	

 	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>

<body>

<div class="container">

	<div class="row">

		<div class="wrap">
			<p class="form-title">Login</p>
		
			<form method="post" action="login">
			
				
				<input type="text" name="usuario" required placeholder="Tu nombre">
				<br>
				<br>	
				<input type="password" name="pass" required>
			
				<br><br>
				
				<%							
						String msg = (String)request.getAttribute("msg");
						if ( msg != null ){
						%>
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<% 
						out.print(msg);
						%>
						</div>	
						<%
						}//end if
				%>
				
				<select name="idioma">
					<option value="es_ES"><fmt:message key="idioma.es.es"/></option>
					<option value="en_EN"><fmt:message key="idioma.en.en"/></option>
				</select>
				
				<input type="submit" class="btn btn-success btn-sm"  value="Enviar" />
			
			</form>
		</div>	
		
	</div> <!-- row -->
</div> <!-- container -->

	<!-- Jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- Boostrap Latest compiled and minified JavaScript -->
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

</body>
</html>
