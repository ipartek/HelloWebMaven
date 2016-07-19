<%@page import="com.ipartek.formacion.pojo.Persona"%>
<%@page import="com.ipartek.formacion.Constantes"%>

<!-- Importamos los TAG de JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<!-- tipo documento es HTML5 -->


<html lang="es">
<head>
<meta charset="utf-8">
<!-- juego de caracteres -->
<title>Hello Web</title>
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


	<!-- fontawesome -->
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">

	<!-- Enlaces a las hojas de Estilos propia -->
	<link rel="stylesheet" href="css/styles.css">

 	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>

<body>

	<%@ include file="nav.jsp" %>


    <div class="container">
     	<div class="jumbotron">
    
    