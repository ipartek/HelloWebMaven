<%@page import="com.ipartek.formacion.Constantes"%>



<%
	String msg = (String)request.getAttribute("msg");
	if(msg != null){
		out.print(msg);
	}
%>

<div class = "container">
	<div class="wrapper">
		<form action="<%=Constantes.WEB_HOME %>login" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Bienvenido! Logéate</h3>
			  <hr class="colorgraph"><br>
			  
			  <input type="text" class="form-control" name="usuario" placeholder="Username" required="" autofocus="" />
			  <input type="password" class="form-control" name="password" placeholder="Password" required=""/>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form>			
	</div>
</div>	  
	