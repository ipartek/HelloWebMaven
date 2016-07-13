<%@ taglib uri="com.ipartek.formacion.tag" prefix="hola"%>
<%@ include file="../includes/head.jsp" %>

<html>
<head>
</head>
<body>
	<h1><i class="fa fa-tag" aria-hidden="true"></i> Ejemplo de Tag propio <i class="fa fa-tag" aria-hidden="true"></i></h1>
	<hr>
	<b>&lt;hola:holamundo/&gt;</b>
	<hola:holamundo/>
	<hr>
	<b>&lt;hola:holamundo nombre="Pepe"/&gt;</b>
	<hola:holamundo nombre="Pepe" />
</body>
</html>

<%@ include file="../includes/footer.jsp" %>