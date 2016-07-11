<%@page import="com.ipartek.formacion.Constantes"%>

<%@ include file="includes/head.jsp"%>


	<%
		String msg = (String)request.getAttribute("msg");
		if(msg != null){%>
			<br><br>
			<div class="alert alert-danger alert.dismissible" role="alert"><%=msg %>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</button>
			</div>
		<%}
	%><br>
	
	<div class="wrapper">
		<form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>login">
			<h1 class="form-signin-heading">Please login</h1><br>
			<input type="text" class="form-control" name="usuario"
				placeholder="Usuario" required="" autofocus="" /><br>
			<input type="password" class="form-control" name="password"
				placeholder="Password" required="" /> <br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
	</div>
	
<%@ include file="includes/footer.jsp"%>