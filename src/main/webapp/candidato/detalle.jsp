<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>

<h1>Detalle del Candidato</h1>


	<%

   //recoge parametro
   
   Candidato c = (Candidato)request.getAttribute("candidato");


%>

 

Nombre:
Apellido1:
Apellido2:
etc...

<%@ include file="../includes/footer.jsp" %>
