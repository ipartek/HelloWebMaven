<%@ include file="../includes/head.jsp" %>

<html>
	<head>
	
	<title>Ejercicio de repaso</title>
	</head>


	<body>
	
		<h1>Ejercicio de repaso GET-POST</h1>
		<br><br>
		
		<!-- Añadir un enlace GET -->
		<a href="<%=Constantes.WEB_HOME%>ejercicio?p1=hola&p2=adios">Envío por GET</a>
		<br><br>
		
		<!-- Añadir un formulario POST -->
		<form action="submit" method="post">
			Nombre: <input type="text" name="p1" value="" placeholder="Introduce tu nombre"><br>
			Edad:<input type="number" name="p2" value="" placeholder="Introduce tu edad"> <br>
			
			<input type="submit" value="Submit">
			
		</form>
		
		
	</body>
</html>

<%@ include file="../includes/footer.jsp" %>