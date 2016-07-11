<%@page import="com.ipartek.formacion.Constantes"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<!-- juego de caracteres -->
<title>Login</title>
<!-- titulo de la pagina-pesta�a -->
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
</head>
<body>


	<div class="container">
		<div class="wrapper">
			<form action="<%=Constantes.WEB_HOME%>login" method="post"
				name="Login_Form" class="form-signin">
				<h3 class="form-signin-heading">Bienvenido! Logéate</h3>
				<hr class="colorgraph">
				<br> <input type="text" class="form-control" name="usuario"
					required placeholder="Tu nombre" autofocus="" /> <input
					type="password" class="form-control" name="password"
					placeholder="Password" required="" />

				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Login" type="Submit">Login</button>
			</form>
		</div>
	</div>

</body>
</html>