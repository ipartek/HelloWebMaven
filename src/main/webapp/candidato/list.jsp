<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@page import="java.util.ArrayList"%>

<%@ include file="../includes/head.jsp" %>
	<div class="navbar-example">
		<h1>Listado Candidatos</h1>
		<%		
			ArrayList<Candidato> lista = new ArrayList<Candidato>();
			for (int i=0; i<10;i++){
				lista.add( new Candidato("Nombre " + (i+1) ,"ape1","ape2","dni","email", 0 ) );
			}	
		%>
		<ol>
			<% for ( Candidato c : lista ) { %>
			<li><a href="candidato/detalle.jsp"><%= c.getDni() + " " + c.getNombre() %></a></li>
			<% } %>
		</ol>
		<a href="index.jsp">
			<div class="btn">Enlace a Home Page</div>
		</a>
	</div>
<%@ include file="../includes/footer.jsp" %>