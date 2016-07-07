<%@ include file="includes/head.jsp" %>


	  <h1>ongi etorri web app</h1>
	  <p><% 
		for(int i=1; i < 7 ; i++ ){
			out.print("<h"+i+">Cabecera"+i+"</h"+i+">");		
		} 
		%></p>
	  <p><a class="btn btn-primary btn-lg" href="candidato/list.jsp" role="button">enlace para listar Candidatos</a></p>


	<!-- <a href="candidato/list.jsp">enlace para listar Candidatos </a> -->

<%@ include file="includes/footer.jsp" %>

