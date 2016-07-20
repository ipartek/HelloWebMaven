<%@page import="com.ipartek.formacion.Constantes"%>

<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Brand</a>
				</div>
	
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="<%=Constantes.CONTROLLER_PLANET%>?op=<%=Constantes.OP_LIST %>">Planetas <span class="sr-only">(current)</span></a></li>
						<li><a href="<%=Constantes.WEB_HOME%>candidato/list.jsp">Candidatos</a></li>
						<li><a href="<%=Constantes.WEB_HOME%>calculadora.jsp">Calculadora</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Ejercicios <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<%=Constantes.WEB_HOME%>ranking">Puntuaciones</a></li>
								<li><a href="<%=Constantes.WEB_HOME%>ejercicios/ejemplo-tag.jsp">TAG propio</a></li>
								<li><a href="<%=Constantes.WEB_HOME%>planeta">Planetas</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					
					<ul class="nav navbar-nav navbar-right">            
			          	<li>
			          		<a href="usuario/info.jsp">
				          		<i class="fa fa-user" aria-hidden="true"></i>
				          		<span class="label label-info">
				            		${sessionScope.userLog.nombre}
				            	</span>
			            	</a>
			          	</li>
			            <li class="active">
			            	<a href="<%=Constantes.WEB_HOME%>logout"><i class="fa fa-lock" aria-hidden="true"></i>&nbsp;Cerrar sesion</a>            	
			            </li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>