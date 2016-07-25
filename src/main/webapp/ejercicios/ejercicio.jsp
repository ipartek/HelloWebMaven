<%@page import="com.ipartek.formacion.controller.EjercicioServlet"%>
<%@ include file="../includes/head.jsp" %>

<html>
	
	<head>
		<title>Ejercicio de repaso</title>
	</head>


	<body>
	
		<h1>Ejercicio de repaso GET-POST</h1>
		<hr>
		
		<!-- Añadir un enlace GET -->
		Enlace por GET
		<br><br>
		<a href="<%=Constantes.WEB_HOME%>ejercicio?pget1=hola&pget2=adios">Envío por GET</a>
		<br><br>
		<hr>
		<br>
		
		
		<!-- Añadir un formulario POST -->
		  
		Formulario POST
		<br><br>
		
		<form action="<%=Constantes.WEB_HOME%>ejercicio" method="post">
		
			<label for="post1">Nombre: </label>
			<input type="text" name="post1" value="" required placeholder="Introduce tu nombre"><br>
			
			<label for="post2">Profesión:</label>   
			<input type="text" name="post2" value="" required placeholder="Introduce tu profesión"> <br>
			
			<input type="submit" class="btn btn-primary"  value="Enviar">
			
		</form>
		
		
	</body>
</html>

<%@ include file="../includes/footer.jsp" %>