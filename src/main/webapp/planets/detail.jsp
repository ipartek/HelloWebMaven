<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@ include file="../includes/head.jsp" %>

<h1>Detalle de ${requestScope.detail.nombre}</h1>
<img src="${requestScope.detail.img}" alt="${requestScope.detail.nombre}"/>
<%@ include file="../includes/footer.jsp" %>