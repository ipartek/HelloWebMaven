<%@ include file="../includes/head.jsp" %>

<!-- jsp:useBean id = "" scope="request"  -->

<h1>${requestScope.planeta.nombre}</h1>

<img src="${requestScope.planeta.imagen}" alt="${requestScope.planeta.nombre}" />
	
	



<%@ include file="../includes/footer.jsp" %>