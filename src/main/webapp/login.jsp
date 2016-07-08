<%@page import="com.ipartek.formacion.Constantes"%>
<%@ include file="../includes/head.jsp" %>

<% 
	String mensaje = (String)request.getAttribute("msg");
	if (mensaje != null){
		out.print(mensaje);
	}
%>


<form method="post" action="<%=Constantes.WEB_HOME %>login" class="form-signin">
        <h2 class="form-signin-heading">Logueese por favor</h2>
        <label for="user" class="sr-only">Usuario</label>
        <input type="text" name="user" class="form-control" placeholder="Usuario" required autofocus>
        
        <label for="inputPassword" class="sr-only">Contraseña</label>
        <input type="password" name="pass" class="form-control" placeholder="Contraseña" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Recordarme
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Loguearse</button>
      </form>

<%@ include file="../includes/footer.jsp" %>