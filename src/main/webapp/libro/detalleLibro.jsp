<%@page import="com.ipartek.formacion.Libro"%>
<%@ include file="../includes/head.jsp" %>



<%
	//recoger parámetro 
	Libro l = (Libro)request.getAttribute("libro");

%>
<h1>Libro <%=l.getTitulo() %></h1>

Titulo:<%=l.getTitulo()%> <br>
Autor:<%=l.getAutor()%> <br>
Paginas:<%=l.getPaginas() %> <br>
ISBN:<%=l.getIsbn() %> <br>


<%@ include file="../includes/footer.jsp" %>
