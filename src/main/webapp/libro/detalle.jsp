<%@page import="com.ipartek.formacion.pojo.Libro"%>
<%@ include file="../includes/head.jsp" %>

      <div class="panel panel-default">
        <div class="panel-heading"><h1><span class="glyphicon glyphicon-book" aria-hidden="true"></span> Detalle del  Libro <span class="glyphicon glyphicon-book" aria-hidden="true"></span></h1></div>
        <div class="panel-body">

<%
	//recoger parametro  del Servlet
	Libro l = (Libro)request.getAttribute("libro");

%>

ISBN: <%=l.getIsbn() %><br>
Titulo: <%=l.getTitulo() %><br>
Autor: <%=l.getAutor() %><br>
N. paginas: <%=l.getPaginas() %><br>

</div></div>

<%@ include file="../includes/footer.jsp" %>
