<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>

<h1>Detalle del Candidato</h1>

<%
	//recoger parametro  del Servlet
	Candidato c = (Candidato)request.getAttribute("candidato");

%>

Nombre: <%=c.getNombre() %><br>
Apellido1: <%=c.getApellido1() %><br>
Apellido2: <%=c.getApellido2() %><br>
etc... <%=c.getNombre() %>

<%@ include file="../includes/footer.jsp" %>
