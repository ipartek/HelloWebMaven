<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>



<%
	//recoger parámetro 
	Candidato c = (Candidato)request.getAttribute("candidato");

%>
<h1>Candidato <%=c.getNombre() %></h1>

Nombre:<%=c.getNombre()%> <br>
Apellido1:<%=c.getApellido1() %> <br>
Apellido2:<%=c.getApellido2() %>  <br>
DNI:<%=c.getDni() %>  <br>
Email:<%=c.getEmail() %> <br>
Nota:<%=c.getNota() %><br>

<%@ include file="../includes/footer.jsp" %>
