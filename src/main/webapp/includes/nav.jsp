<!-- Fixed navbar -->
    <%@page import="com.ipartek.formacion.pojo.Persona"%>
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
          <a class="navbar-brand">Hello Web Maven</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=Constantes.CONTROLLER_PLANETS%>?op=<%=Constantes.OP_LIST%>"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;Planetas</a></li>
            <li><a href="<%=Constantes.CONTROLLER_PERSONAS%>?op=<%=Constantes.OP_LIST%>"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;Candidatos</a></li>
            <li><a href="<%=Constantes.WEB_HOME%>libro/list.jsp"><i class="fa fa-book" aria-hidden="true"></i> Libros</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ejercicios <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="<%=Constantes.WEB_HOME%>calculadora/calculadora.jsp"><i class="fa fa-calculator" aria-hidden="true"></i> Calculadora</a></li>
                <li><a href="<%=Constantes.WEB_HOME%>puntuacion"><i class="fa fa-hand-o-up" aria-hidden="true"></i> Puntuaciones</a></li>
                <li><a href="<%=Constantes.WEB_HOME%>ejercicios/ejemplo-tag.jsp"><i class="fa fa-tag" aria-hidden="true"></i> Tag Propio</a></li>
                <li><a href="<%=Constantes.WEB_HOME%>planetas"><i class="fa fa-globe" aria-hidden="true"></i> Planetas</a></li>
              </ul>
			</li>
          </ul>
          <ul class="nav navbar-nav navbar-right">            
          	<li>
          		<a href="usuario/info.jsp">
	          		<i class="fa fa-user" aria-hidden="true"></i>
	          		<span class="label label-info">
	          		<%
	            		Persona p = (Persona)session.getAttribute("usuario_logeado");
	            		if ( p != null ){
	            			out.print( p.getNombre() );
	            		}	
	            	%>
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
 	<!-- END:Fixed navbar -->