<%@page import="com.ipartek.formacion.pojo.Libro"%>

<%@ include file="../includes/head.jsp" %>

<h1>Detalle del Libro</h1>
 
<%
	//recoger parametro
	Libro l = (Libro)request.getAttribute("libro");

%>

Titulo: <%=l.getTitulo() %><br>
Autor:<br>
Número Páginas:<br>
ISBN:<br>  


<%@ include file="../includes/footer.jsp" %>