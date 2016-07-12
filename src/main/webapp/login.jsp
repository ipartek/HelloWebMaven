<%@ include file="includes/head.jsp" %>
<%@page errorPage="error.jsp" %>
	<div class="navbar-example">
		<form action="<%= Constantes.WEB_HOME %>login" method="POST">
			<h3><i class="fa fa-home" aria-hidden="true"></i> LOGIN</h3>
			<input type="text" name="user" class="txt" placeholder="Introduce el nombre de usuario..." required autofocus>
			<input type="password" name="pass" class="txt" placeholder="Introduce la contraseña..." required>
			<input type="submit" class="btn" value="LOGIN">
			 <% if (request.getAttribute("error") != null) { %>
			<h6 class="error">${ error }</h6>
			<% } %>
		</form>
	</div>
<%@ include file="includes/footer.jsp" %>