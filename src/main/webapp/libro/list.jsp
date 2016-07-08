<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../includes/head.jsp" %>


      <!-- Main component for a primary marketing message or call to action -->
      <div class="panel panel-warning">
        <div class="panel-heading"><h1><span class="glyphicon glyphicon-book" aria-hidden="true"></span> Listado Libros <span class="glyphicon glyphicon-book" aria-hidden="true"></span></h1></div>
        <div class="panel-body">

<%
		
	ArrayList<Libro> lista = new ArrayList<Libro>();
	for (int i=0; i<5;i++){
		lista.add (new Libro(String.valueOf(i+1), "Desconocido", "Anonimo", 200));
	}
		
%>

<!-- OL Lista Ordenada en HTML  -->
<ol>
	<% int i= 0;
	   for ( Libro l : lista ) { 
	   		i++;
	%>
	
			<li><a href="libro?isbn=<%=i%>"><%=l.getIsbn() + " - " + l.getTitulo() %></a></li>
	
	<% } //final del for %>
</ol> 

     </div>
	</div>


<%@ include file="../includes/footer.jsp" %>





