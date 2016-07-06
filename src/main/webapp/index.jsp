<!doctype html>
<!-- tipo documento es HTML5 -->

<%@page import="com.ipartek.formacion.Cancion"%>
<html lang="es">
<head>
  <meta charset="utf-8"> <!-- juego de caracteres -->
  <title>Hello Web</title> <!-- titulo de la pagina-pestaña -->
  
  <meta name="description" content="App Web con JEE">
  <meta name="author" content="Ipartek Formacion SL">

  <!-- Enlaces a las hojas de Estilos -->
  <link rel="stylesheet" href="css/styles.css?v=2.0">

  <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>

<body>
	<!--  Etiquetas para que se visualice a los usuarios -->
		
	<% 
	for(int i=1; i < 7 ; i++ ){
		out.print("<h"+i+">Cabecera"+i+"</h"+i+">");		
	} 
	%>
	
	
	<% 
		Cancion c = new Cancion("Crwaling in the dark");
		out.print(c);
	%>
	
	<!-- enlaces a ficheros JavaScript -->
  	<script src="js/scripts.js"></script>
</body>

</html>


