<%@ include file="includes/head.jsp" %>
	<div class="navbar-example">
		<form action="<%= Constantes.WEB_HOME %>login" method="POST">
			<h1>>>LOGIN</h1>
			<input type="text" name="user" class="txt" placeholder="Introduce el nombre de usuario..." required autofocus>
			<input type="password" name="pass" class="txt" placeholder="Introduce la contraseña..." required>
			<input type="submit" class="btn" value="Login">
			<h6 class="error">${ error }</h6>
		</form>
	</div>
<%@ include file="includes/footer.jsp" %>