<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@ include file="../includes/head.jsp" %>

<h1>Detalle del Libro</h1>

<%
	//recoger parametro  del Servlet
	Libro l = (Libro)request.getAttribute("libro");

%>

ISBN: <%=l.getIsbn() %><br>
Titulo: <%=l.getTitulo() %><br>
Autor: <%=l.getAutor() %><br>
N. paginas: <%=l.getPaginas() %><br>

<%@ include file="../includes/footer.jsp" %>
