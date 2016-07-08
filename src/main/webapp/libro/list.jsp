<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../includes/head.jsp" %>


<h1>Listado Libros</h1>

<%
		
	ArrayList<Libro> lista = new ArrayList<Libro>();
	for (int i=0; i<10;i++){
		lista.add( new Libro("Titulo"+(i+1),"Autor","Isbn",0));
	}
		
%>

<!-- OL Lista Ordenada en HTML  -->
<ol>
	<% 
		int i = 0;
		for ( Libro l : lista ) {
			i++;
	%>
	
			<li><a href="libro?id=<%=i%>&p2=autor&p3=123-45-89&p4=0"><%=l.getTitulo() + " " + l.getAutor() %></a></li>
	
	<% } //final del for %>
</ol>
<%@ include file="../includes/footer.jsp" %>