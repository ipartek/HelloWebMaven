<%@page import="com.ipartek.formacion.pojo.Persona"%>
<%@page import="com.ipartek.formacion.Constantes"%>

<!-- Importamos los TAG de JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
	<!-- tipo documento es HTML5 -->
	
	<html lang="es">
	
	<head>
	<meta charset="utf-8">
	<title>Hello Web</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
	<link rel="stylesheet" href="css/styles.css">
	<base href="<%=Constantes.WEB_HOME%>">
	
	<meta name="description" content="App Web con JEE">
	<meta name="author" content="Ipartek Formacion SL">
	
	<!--[if lt IE 9]>
			    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
			  <![endif]-->
	</head>
	
	<body>
	
		<%@ include file="nav.jsp" %>
		
		<div class="container">