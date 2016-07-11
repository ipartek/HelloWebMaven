
<%@page import="com.ipartek.formacion.Constantes"%>
<%@ include file="../includes/head.jsp" %>

<!--  <form method="post" action="<%=Constantes.WEB_HOME%>login">
	<h1>Identifiquese para continuar</h1><br />
	<label for="usuario">Usuario:</label> 
	<input type="text" name="usuario" required><br /><br />
	
	<label for="password">Contrase�a:</label> 
	<input type="text" name="password" required><br /><br />
	
	<input type="submit" value="Enviar" />
</form> -->

<!-- Jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- Boostrap Latest compiled and minified JavaScript -->
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>


<div class="wrapper">
    <form class="form-signin" method="post" action="<%=Constantes.WEB_HOME%>login">       
      <h2 class="form-signin-heading">Identifiquese para continuar</h2>
      <%
	String msg = (String)request.getAttribute("msg");
	if (msg!=null){
		%><div class="alert alert-danger" role="alert"><%=msg%>
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;
		</div><%
	}
%>
      <input type="text" class="form-control" name=usuario placeholder="Nombre" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Contraseña" required=""/>      
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Recuerdame
      </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit" value="">Enviar</button>
    </form>
  </div>
  
<%@ include file="../includes/footer.jsp" %>