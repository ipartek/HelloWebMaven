<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>
<br><br><br><br>
<h1>Detalle del Candidato</h1>

<%
	//recoger parametro
	Candidato c=(Candidato)request.getAttribute("candidato");

%>

Nombre:<%=c.getNombre()%><br>
Apellido1:
Apellido2:
etc...

<%@ include file="../includes/footer.jsp" %>
