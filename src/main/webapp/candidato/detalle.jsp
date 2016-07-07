<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>

<h1>Detalle del Candidato</h1>

<%
	//recoger parametro
	Candidato c = (Candidato)request.getAttribute("candidato");

%>

Nombre: <%=c.getNombre() %><br>
Apellido1:<br>
Apellido2:<br>
etc...<br>

<%@ include file="../includes/footer.jsp" %>
