<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ipartek.formacion.pojo.Candidato"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp" %>
<h1>Listado Candidatos</h1>
<!-- OL Lista Ordenada en HTML  -->
<ol>
	<c:forEach var="c" items="${ list }">
		<li>${ c.nombre } | ${ c.apellido }</li>
	</c:forEach>
</ol>
<%@ include file="../includes/footer.jsp" %>