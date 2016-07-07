<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../includes/head.jsp" %>


<h1>Listado Libros</h1>

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


<%@ include file="../includes/footer.jsp" %>





