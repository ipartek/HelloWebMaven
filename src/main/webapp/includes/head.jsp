<%@page import="com.ipartek.formacion.pojo.Persona"%>
<%@page import="com.ipartek.formacion.Constantes"%>

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

 <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=Constantes.WEB_HOME%>">Inicio</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>candidato/list.jsp">Candidatos</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>libro/listLibro.jsp">Libros</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>calculadora/calculadora.jsp">Calculadora</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>ranking">Puntuaciones</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ejercicios <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="<%=Constantes.WEB_HOME%>hello">Servlet Hello</a></li>
                <li><a href="<%=Constantes.WEB_HOME%>candidato/list.jsp">Candidatos</a></li>
            	<li><a href="<%=Constantes.WEB_HOME%>libro/listLibro.jsp">Libros</a></li>
            	<li><a href="<%=Constantes.WEB_HOME%>calculadora/calculadora.jsp">Calculadora</a></li>
            	<li><a href="<%=Constantes.WEB_HOME%>ranking">Puntuaciones</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<li>
          		<a href="usuario/info.jsp">
          		<i class="fa fa-user" aria-hidden="true"></i>
          		<span class="label label-info">
	            
	          	<%
		            	Persona p = (Persona) session.getAttribute("usuario_logeado");
		            	if (p!=null){
		            		out.print(p.getNombre());
		            	}
		           %>
		           
		           <!-- expresión por la que  ${sessionScope.usuario_logeado.nombre } se podría sustituir-->
		         
	            </span>
	          	</a>	           
	         </li>
            <li class="active">
	            <a href="<%=Constantes.WEB_HOME%>logout"><i class="fa fa-lock" aria-hidden="true"></i>&nbsp;Cerrar</a>
	            
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <!--  End:Fixed navbar -->

    <div class="container">
		<div class="jumbotron">
	
