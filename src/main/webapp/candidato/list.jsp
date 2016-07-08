<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@page import="java.util.ArrayList"%>


<%@ include file="../includes/head.jsp" %>


<h1>Listado Candidatos</h1>

<%
		
	ArrayList<Candidato> lista = new ArrayList<Candidato>();
	for (int i=0; i<10;i++){
		lista.add( new Candidato("Nombre " + (i+1) ,"ape1","ape2","dni","email", 0 ) );
	}
		
%>

<!-- OL Lista Ordenada en HTML  -->
<ol>
	<% 
	int i = 0;
	for ( Candidato c : lista ) {
		i++;
		%>
	
			<li><a href="candidato?id=<%=i%>"><%=c.getDni() + " " + c.getNombre() %></a></li>
	
	<% } //final del for %>
</ol>


<%@ include file="../includes/footer.jsp" %>





