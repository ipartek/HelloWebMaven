<%@page import="com.ipartek.formacion.Constantes"%>
<%@ page isErrorPage="true"%>

<!doctype html>
<!-- tipo documento es HTML5 -->


<html lang="es">
	<head>
	  <meta charset="utf-8"> <!-- juego de caracteres -->
	  <title>Hello Web</title> <!-- titulo de la pagina-pesta�a -->
	  
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	   <meta name="viewport" content="width=device-width, initial-scale=1">
	  
	  <base href="<%=Constantes.WEB_HOME%>">
	  <meta name="description" content="App Web con JEE">
	  <meta name="author" content="Ipartek Formacion SL">
	
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
		
		
		
		  
		  <!-- Enlace a Font awesome -->
		  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
		
			<!-- Enlaces a las hojas de Estilos -->
		  <link rel="stylesheet" href="css/styles.css?v=3.0">
		
		   <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		    <!--[if lt IE 9]>
		      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		    <![endif]-->
	</head>

<body>

	<div class="container">
	 <div class="row">
	    <div class="span12">
	      <div class="hero-unit center">
	          <h1>Página no encontrada <small><font face="Tahoma" color="red">Error 404</font></small></h1>
	          <br />
	          <p>La página que ha solicitado no se ha encontrado. Consulte con su webmaster o inténtelo de nuevo. Use el botón <b>Atrás</b> del navegador para volver a la página anterior </p>
	          <p><b>O puedes pulsar en este bonito botón:</b></p>
	          <a href="<%=Constantes.WEB_HOME%>" class="btn btn-large btn-info"><i class="icon-home icon-white"></i> Llévame a casa</a>
	       </div>
	    </div>
	 </div>
 	</div>
 
 	</body>
</html>