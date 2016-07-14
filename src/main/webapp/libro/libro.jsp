<%@page import="com.ipartek.formacion.pojo.Libro"%>

<%@ include file="../includes/head.jsp" %>

<h1>Detalle del Libro</h1>


	<%

   //recoge parametro
   
   Libro c = (Libro)request.getAttribute("libro");
   


%>

 

Nombre:
Apellido1:
Apellido2:
etc...

<%@ include file="../includes/footer.jsp" %>