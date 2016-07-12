<%@page import="com.ipartek.formacion.Constantes"%>
<!doctype html>
<!-- tipo documento es HTML5 -->


<html lang="es">
	<head>
	  <meta charset="utf-8"> <!-- juego de caracteres -->
	  <title>Login</title> <!-- titulo de la pagina-pesta�a -->
	  
	  <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

	 <!-- Enlaces a las hojas de Estilos -->
  	<link rel="stylesheet" href="css/styles.css?v=2.0">
	  
	</head>
	<body>
		<div class="container" >
			<div class="jumbotron" >
		<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
				out.print("<div class='alert alert-warning alert-dismissible'> <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button><strong>Warning! </strong>"+ msg + "</div>");
				
			}
		%>

			
	
		      <form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>login">
		        
		        <label for="usuario" class="sr-only">Usuario</label>
		        <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Usuario" required autofocus>
		        <label for="pass" class="sr-only">Contraseña</label>
		        <input type="password" id="pass" name="pass" class="form-control" placeholder="Contraseña" required>
		        <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
		      </form>
	      </div>

    </div> <!-- /container -->
    
    <!--  Jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	
	</body>  
</html>