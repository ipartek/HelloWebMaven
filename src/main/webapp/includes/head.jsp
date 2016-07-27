<%@page import="com.ipartek.formacion.pojo.Persona"%>
<%@page import="com.ipartek.formacion.Constantes"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<!-- tipo documento es HTML5 -->


<html lang="es">

<head>
<meta charset="utf-8">
<title>Hello Web</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<!--Data table  -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">


<link rel="stylesheet" href="css/styles.css?v=2.0">

<base href="<%=Constantes.WEB_HOME%>">

<meta name="description" content="App Web con JEE">
<meta name="author" content="Ipartek Formacion SL">

<!--[if lt IE 9]>
			    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
			  <![endif]-->
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_LIST%>">Planetas
							<span class="sr-only">(current)</span>
					</a></li>
					<li><a href="<%=Constantes.WEB_HOME%>candidato/list.jsp">Candidatos</a></li>
					<li><a href="<%=Constantes.WEB_HOME%>candidato/list.jsp">Libros</a></li>
					<li><a href="<%=Constantes.WEB_HOME%>calculadora.jsp">Calculadora</a></li>
					<li><a href="<%=Constantes.CONTROLLER_PERSONS%>?op=<%=Constantes.OP_LIST%>">Personas</a></li>
					<li class="dropdown"><a
						href="<%=Constantes.WEB_HOME%>ejercicios" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Ejercicios <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=Constantes.WEB_HOME%>ranking">Puntuacion</a></li>
							<li><a href="<%=Constantes.WEB_HOME%>hello">Servlet
									hello</a></li>
							<li><a
								href="<%=Constantes.WEB_HOME%>ejercicios/ejemplo-tag.jsp">tag</a></li>
							<li role="separator" class="divider"></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<%=Constantes.WEB_HOME%>logout"><span
							class="glyphicon glyphicon-lock" aria-hidden="true">
								Logout</span></a> <%
 	Persona p = (Persona) session.getAttribute("usuario");
 	if (p != null) {
 		out.print(p.getNombre());
 	}
 %></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">DropToDown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container">