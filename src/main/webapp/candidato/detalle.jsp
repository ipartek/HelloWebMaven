<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@ include file="../includes/head.jsp" %>

      <div class="panel panel-default">
        <div class="panel-heading"><h1><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Detalle del Candidato <span class="glyphicon glyphicon-user" aria-hidden="true"></span></h1></div>
        <div class="panel-body">

<%
	//recoger parametro  del Servlet
	Candidato c = (Candidato)request.getAttribute("candidato");

%>

Nombre: <%=c.getNombre() %><br>
Apellido1: <%=c.getApellido1() %><br>
Apellido2: <%=c.getApellido2() %><br>
etc... <%=c.getNombre() %>

</div></div>

<%@ include file="../includes/footer.jsp" %>
