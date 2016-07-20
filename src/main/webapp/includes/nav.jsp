<%@page import="com.ipartek.formacion.Constantes"%>
<!-- Fixed navbar -->
    
<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_LIST%>">Planetas</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>candidato/list.jsp">Candidatos</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>libro/listLibro.jsp">Libros</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>calculadora/calculadora.jsp">Calculadora</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>ranking">Puntuaciones</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ejercicios <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="<%=Constantes.WEB_HOME%>hello">Servlet Hello</a></li>
                <li><a href="<%=Constantes.WEB_HOME%>candidato/list.jsp">Candidatos</a></li>
            	<li><a href="<%=Constantes.WEB_HOME%>libro/listLibro.jsp">Libros</a></li>
            	<li><a href="<%=Constantes.WEB_HOME%>calculadora/calculadora.jsp">Calculadora</a></li>
            	<li><a href="<%=Constantes.WEB_HOME%>ranking">Puntuaciones</a></li>
            	<li><a href="<%=Constantes.WEB_HOME%>ejercicios/ejemplo-tag.jsp">Tag Propio</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<li>
          		<a href="usuario/info.jsp">
          		<i class="fa fa-user" aria-hidden="true"></i>
          		<span class="label label-info">
	            
	          	${sessionScope.usuario_logeado.nombre}
		           
		           <!-- expresión por la que  ${sessionScope.usuario_logeado.nombre } se podría sustituir-->
		         
	            </span>
	          	</a>	           
	         </li>
            <li class="active">
	            <a href="<%=Constantes.WEB_HOME%>logout"><i class="fa fa-lock" aria-hidden="true"></i>&nbsp;Cerrar</a>
	            
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <!--  End:Fixed navbar -->