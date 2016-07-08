<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@ include file="../includes/head.jsp" %>



<%
	//recoger parametro
	Libro l = (Libro)request.getAttribute("libro");
%>

<h1>Libro: <%=l.getTitulo()%></h1>


Titulo: <%=l.getTitulo()%><br>
Autor: <%=l.getAutor()%><br>
Isbn: <%=l.getIsbn()%><br>
paginas:<%=l.getPaginas()%><br>

<%@ include file="../includes/footer.jsp" %>