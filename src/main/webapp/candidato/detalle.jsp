<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>
<br><br><br><br>
<h1>Detalle del Candidato</h1>

<%
	//recoger parametro
	Candidato c=(Candidato)request.getAttribute("candidato");

%>

Nombre:<%=c.getNombre()%><br>
Apellido1:<%=c.getApellido1()%><br>
Apellido2:<%=c.getApellido2() %><br>
Dni:<%=c.getDni()%><br>
Nota:<%=c.getNota()%><br>


<%@ include file="../includes/footer.jsp" %>
