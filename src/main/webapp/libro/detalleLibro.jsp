<%@page import="com.ipartek.formacion.pojo.Libro"%>

<%@ include file="../includes/head.jsp" %>

<h1>Detalle del Libro</h1>
 
<%
	//recoger parametro
	Libro l = (Libro)request.getAttribute("libro");

%>
<div style="background-color: rgb(200,200,200);color:black;padding:20px;">
Titulo: <%=l.getTitulo() %><br>
Autor:<br>
Número Páginas:<br>
ISBN:<br>  
</div>

<%@ include file="../includes/footer.jsp" %>