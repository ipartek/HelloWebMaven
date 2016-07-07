<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../includes/head.jsp" %>

<h1>Listado Libros</h1>

<%
		
	ArrayList<Libro> lista = new ArrayList<Libro>();
	for (int i=0; i<8;i++){
		lista.add( new Libro ("Titulo libro"+ (i+1)) );
	}
		
%>

<!-- OL Lista Ordenada en HTML  -->
<ol>
	<% 
		int i = 0;
		for ( Libro l : lista ) { 
	 		i++;
	%>
	
			<li><a href="libro?id=<%=i %>&p2=pepe&p3=manolin"><%=l.getTitulo() + " " + l.getAutor()  %></a></li>
	
	<% } //final del for %>
</ol>



<%@ include file="../includes/footer.jsp" %>