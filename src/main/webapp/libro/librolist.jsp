<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../includes/head.jsp" %>


<h1>Listado Candidatos</h1>

<%
		
	ArrayList<Libro> lista = new ArrayList<Libro>();
	for (int i=0; i<10;i++){
	//	lista.add( new Libro("Ulises" + (i+1)   ) );
	}
		
%>




<%@ include file="../includes/footer.jsp" %>