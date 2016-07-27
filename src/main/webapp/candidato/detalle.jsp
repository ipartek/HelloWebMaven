<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>



<%
	//recoger parametro
	Candidato c = (Candidato)request.getAttribute("candidato");
%>

<h1>Candidato: <%=c.getNombre()%></h1>


Nombre: <%=c.getNombre()%><br>
Email: <%=c.getEmail()%><br>
Nota: <%=c.getNota()%><br>

<%@ include file="../includes/footer.jsp" %>