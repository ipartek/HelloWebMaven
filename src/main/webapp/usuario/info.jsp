
<%@ include file="../includes/head.jsp"%>

	
	<br><br><br><br>
	<form action = "#" method="post">
	
		<label for="nombre">Nombre:</label>
		<input type="text" name="nombre"  value=" ${sessionScope.userLog.nombre}">
		<br><br>
	
	
	<input type="submit" class="btn btn-info">
	
	
	</form>


<%@ include file="../includes/footer.jsp"%>