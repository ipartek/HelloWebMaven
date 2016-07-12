<%@page import="com.ipartek.formacion.Constantes"%>

<!doctype html>
<!-- tipo documento es HTML5 -->


<html lang="es">
<head>
  <meta charset="utf-8"> <!-- juego de caracteres -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>Hello Web</title> <!-- titulo de la pagina-pestaña -->   
  <base href="<%=Constantes.WEB_HOME%>">
  <meta name="description" content="App Web con JEE">
  <meta name="author" content="Ipartek Formacion SL">
  
 <!-- Custom styles for login template -->
   <link href="css/singin.css?v=2.0" rel="stylesheet">    
   
  
  <!-- Enlaces a las hojas de Estilos -->
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body >



<form method="post" action="<%=Constantes.WEB_HOME %>login" class="form-signin">
        <h2 class="form-signin-heading">Logueese por favor</h2>
        
        <label for="user" class="sr-only">Usuario</label>
        <div class="input-group">
  		<span class="input-group-addon" id="basic-addon1"><i class="fa fa-user" aria-hidden="true"></i></span>
  		<input type="text" name="user" class="form-control" placeholder="Usuario" required autofocus>
  		</div>
        
        <label for="inputPassword" class="sr-only">Contraseña</label>
  		
        <input type="password" name="pass" class="form-control" placeholder="Contraseña" required>
        
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Recordarme
          </label>
        </div>
        
        <% 
	String mensaje = (String)request.getAttribute("msg");
	if (mensaje != null){
		%>
		<div class="alert alert-danger alert-dismissible" role="alert">
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  

		<%
		out.print(mensaje);
		%>
		</div>
		<%
	}
%>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Loguearse</button>
      </form>

<%@ include file="../includes/footer.jsp" %>