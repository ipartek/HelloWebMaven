<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../includes/head.jsp" %>


<h1>Listado Libros</h1>

<%
		
	ArrayList<Libro> lista = new ArrayList<Libro>();
	for (int i=0; i<10;i++){
		lista.add( new Libro("Titulo"+i) );
	}
		
%>

<!-- OL Lista Ordenada en HTML  -->
<ol>
	<% 
		int i = 0;
		for ( Libro l : lista ) {
			i++;
	%>
	
			<li><a href="libro?id=<%=i%>"><%=l.getTitulo()%></a></li>
	
	<% } //final del for %>
</ol>
<%@ include file="../includes/footer.jsp" %>