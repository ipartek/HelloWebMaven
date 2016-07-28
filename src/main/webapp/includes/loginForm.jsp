<%@page import="com.ipartek.formacion.Constantes"%>


<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<!-- juego de caracteres -->
<title>Login</title>
<!-- titulo de la pagina-pestaña -->

<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			%>
			<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<%
			out.print(msg);
			 %>
			 </div>
			 <%
		}
	%>
	
	
	
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

<!-- fontawesome -->
<link href= "https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">


	<!-- Enlaces a las hojas de Estilos propia -->
	<link rel="stylesheet" href="css/styles.css?v=2.0">

 	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->	
	
	
</head>
<body>

<div class="container">
		<div class="wrapper">
			<form action="<%=Constantes.WEB_HOME%>login" method="post"
				name="Login_Form" class="form-signin">
				<h3 class="form-signin-heading">¡Bienvenido! Logéate</h3>
				<hr class="colorgraph">
				<br> <input type="text" class="form-control" name="usuario"
					required placeholder="Tu nombre" autofocus="" /> <input
					type="password" class="form-control" name="password"
					placeholder="Password" required="" />
				
<%-- 				<% 
// 					Cookie cookies[] = request.getCookies();
// 					String idioma = "es";
// 					for (int i=0; i < cookies.length; i++){
// 						if ("cidioma".equals(cookies[i].getName())){
// 							idioma = cookies[i].getValue();
// 							break;
// 						}
// 					}
 				%> --%>
<!-- 				<label for="idioma">Selecciona Idioma:</label> -->
					<select name=idioma>
<%-- 						<%if ( "es".equals(idioma)){ %> --%>
						<option value="es" selected>Castellano</option>
						<option value="en" >Ingles</option>
<%-- 						<%} else {%> --%>
<!-- 						<option value="en" selected>Ingles</option> -->
<!-- 						<option value="es" >Castellano</option> -->
<%-- 						<%} %> --%>
					</select>
				<br><br><br>	
				
				<input type="submit" value="Login" />
<!-- 				<button class="btn btn-lg btn-primary btn-block" name="Submit" -->
<!-- 					value="Login" type="Submit" >Login</button> -->
			
			</form>
		</div>
	</div>

</body>
</html>