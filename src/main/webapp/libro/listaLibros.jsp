<%@page import=" +1.pojo.Libro"%>
<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../includes/head.jsp" %>

<h1>Listado Libros</h1>

<%
		
	ArrayList<Libro> lista = new ArrayList<Libro>();
	for (int i=0; i<10;i++){
		lista.add( new Libro ("titulo"+ (i+1)) );
	}
		
%>


<%@ include file="../includes/footer.jsp" %>