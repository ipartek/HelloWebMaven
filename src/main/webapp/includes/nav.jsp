   <!-- Fixed navbar -->
    <%@page import="com.ipartek.formacion.Constantes"%>
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
            <li class="hover"><a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_LIST%>">Planetas</a></li>
             <li class="hover"><a href="<%=Constantes.CONTROLLER_PERSONA%>?op=<%=Constantes.OP_LIST%>">Personas</a></li>
             <li class="hover"><a href="candidato/list.jsp">Candidato</a></li>
            <li class="hover"><a href="libro/listaLibros.jsp">Libro</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ejercicios <span class="caret"></span></a>
              <ul class="dropdown-menu">
              	<li><a href="<%=Constantes.WEB_HOME%>hello">Servlet Hello</a></li>
                <li><a href="<%=Constantes.WEB_HOME%>ejercicios/calculadora.jsp">Calculadora</a></li>
                <li><a href="<%=Constantes.WEB_HOME%>ranking">JSTL-Puntuaciones</a></li>
                <li><a href="<%=Constantes.WEB_HOME%>ejercicios/ejemplo-tag.jsp">TAG propio</a></li>
                <li><a href="#">Something else here</a></li>
               
              </ul>
            </li>
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ejemplos <span class="caret"></span></a>
              <ul class="dropdown-menu">
              	<li><a href="<%=Constantes.WEB_HOME%>planetas">Planetas</a></li>
              	<li><a href="<%=Constantes.WEB_HOME%>ejercicios/ejercicio.jsp">Ejercicio de repaso</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li>
            	<a href="usuario/info.jsp">
         		<i class="fa fa-user" aria-hidden="true"></i>
        		<span class="label label-info">
        		           		
           		${sessionScope.usuario_logeado.nombre}
           		
            	</span></a>
          	</li>
          <li class="active">
            	<a href="<%=Constantes.WEB_HOME%>logout"><i class="fa fa-lock" aria-hidden="true"></i>&nbsp;Cerrar</a>            	
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
     <!-- END: Fixed navbar -->