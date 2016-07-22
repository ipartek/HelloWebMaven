<%@ include file="../includes/head.jsp" %>


<h1>Ejercicio GET y POST</h1>

<h2>Envio por GET</h2>

<a href="ejercicios?p1=Hola&p2=Adios">peticion de tipo get</a>


<h2>Envio por POST</h2>
<form action="ejercicios" method="post">

	
	<input type="text" name="post1"  value="">
	<input type="text" name="post2" value="">
	
	<input type="submit" value="submit">
	<br>

	
</form>

<%@ include file="../includes/footer.jsp" %>
