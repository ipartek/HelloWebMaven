<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>






<%@page import="com.ipartek.formacion.pojo.Planetas"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp"%>

<div id="planetas">

	<h1>Base de datos de planetas</h1>

	<h2>JAVA</h2>
	<table class="table table-striped custab">
		<tbody>
			<%
				ArrayList<Planetas> lista = (ArrayList<Planetas>) request.getAttribute("planetas");
				for (Planetas p : lista) {
			%>
			<tr>
				<td><%=p.getImg()%></td>
				<td><%=p.getName() %></td>
				<td><%=p.getDistance()%></td>
			</tr>

			<%
				} //end for
			%>
		</tbody>
	</table>


</div>

<%@ include file="../includes/footer.jsp"%>