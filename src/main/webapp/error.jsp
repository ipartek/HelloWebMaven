<%@ page isErrorPage="true"%>

Soy una pagina de Error

Excepcion:<br />
<%=exception%>

Mensaje:<br />
<%=exception.getMessage()%>
<br />

Traza:
<%=exception.printStackTrace()%>
