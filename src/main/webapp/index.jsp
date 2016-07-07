<%@ include file="includes/head.jsp" %>

	<div class="navbar-example">
		<h1>Navbar example</h1>
		<p>This example is a quick exercise to illustrate how the default, 
		static and fixed to top navbar work. It includes the responsive 
		CSS and HTML, so it also adapts to your viewport and device.</p>
		<p>To see the difference between static and fixed top navbars, 
		just scroll.</p>
		<button>View navbar docs >></button>
	</div>
	<!--  Etiquetas para que se visualice a los usuarios -->
	<h1>ongi etorri web app</h1>
	
	<% 
	for(int i=1; i < 7 ; i++ ){
		out.print("<h"+i+">Cabecera"+i+"</h"+i+">");		
	} 
	%>
	
	<a href="candidato/list.jsp">enlace para listar Candidatos</a>

<%@ include file="includes/footer.jsp" %>

