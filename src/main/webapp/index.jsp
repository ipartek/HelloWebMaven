<%@ include file="includes/head.jsp" %>

	

	


    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="panel panel-success">
        <div class="panel-heading"><h1>ongi etorri web app</h1></div>
        <div class="panel-body">
	<% 
	for(int i=1; i < 7 ; i++ ){
		out.print("<h"+i+">Cabecera"+i+"</h"+i+">");		
	} 
	%>
          <a class="btn btn-lg btn-success" href="candidato/list.jsp" role="button">Listar Candidatos</a>
          <a class="btn btn-lg btn-warning" href="libro/list.jsp" role="button">Listar Libros</a>
        
      </div>
	</div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

<%@ include file="includes/footer.jsp" %>

