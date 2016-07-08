<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>
<br><br><br><br>
<h1>Detalle del Candidato</h1>

<%
	//Recoger parametro
	Candidato c = (Candidato)request.getAttribute("candidato");

%>

Nombre:   <%=c.getNombre() %><br>


<%@ include file="../includes/footer.jsp" %>
