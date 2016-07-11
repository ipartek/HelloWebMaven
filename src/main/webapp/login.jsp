<%@page import="com.ipartek.formacion.Constantes"%>
<%@ include file="../includes/head.jsp" %>




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