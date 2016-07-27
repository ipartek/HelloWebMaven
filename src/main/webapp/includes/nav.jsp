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
          <a class="navbar-brand" href="<%=Constantes.WEB_HOME %>index.jsp">HelloWebMaven</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="<%=Constantes.WEB_HOME %>candidato/list.jsp"><i class="fa fa-users" aria-hidden="true"></i> Candidatos</a></li>
            <li><a href="<%=Constantes.WEB_HOME %>libro/list.jsp"><i class="fa fa-book" aria-hidden="true"></i> Libros</a></li>
            
            <li class="dropdown">          
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-pencil" aria-hidden="true"></i>
             Bases de Datos <span class="caret"></span></a>
          		<ul class="dropdown-menu">
           		 <li><a href="<%=Constantes.CONTROLLER_PLANET %>?op=<%=Constantes.OP_LIST %>"><i class="fa fa-star" aria-hidden="true"></i>&nbsp;Planetas</a></li>
           		 <li><a href="<%=Constantes.CONTROLLER_PERSONA %>?op=<%=Constantes.OP_LIST %>"><i class="fa fa-users" aria-hidden="true"></i>&nbsp;Personas</a></li>                
            	</ul>
            </li>
            <li class="dropdown">            
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-pencil" aria-hidden="true"></i>
               Ejercicios <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">Ejercicios</li>
             	<li><a href="<%=Constantes.WEB_HOME %>ejercicios/calculadora.jsp"><i class="fa fa-calculator" aria-hidden="true"></i> Calculadora</a></li>
                <li><a href="<%=Constantes.WEB_HOME %>ranking"><i class="fa fa-gamepad" aria-hidden="true"></i> JSTL-Puntuaciones</a></li>
                <li><a href="<%=Constantes.WEB_HOME %>planetas"><i class="fa fa-star-o" aria-hidden="true"></i> Planetas</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Ejemplos</li>
                <li><a href="<%=Constantes.WEB_HOME %>hello"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;Servlet Hello</a></li>                
                <li><a href="<%=Constantes.WEB_HOME %>ejercicios/ejemplo-tag.jsp"><i class="fa fa-tags" aria-hidden="true"></i> TAG propio</a></li>
              </ul>
            </li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>

          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li>
            <a href="<%=Constantes.WEB_HOME %>usuario/info.jsp">
            <span class="label label-info">
            <i class="fa fa-user" aria-hidden="true"></i>
           
           ${sessionScope.usuario_logeado.nombre}
           
            </span></a></li>
            <li><a href="<%=Constantes.WEB_HOME %>logout"><i class="fa fa-lock" aria-hidden="true"></i> Salir</a>
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <!-- END Fixed navbar -->