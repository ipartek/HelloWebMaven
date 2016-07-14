<%@ include file="../includes/head.jsp" %>

<H1>Informacion del Usuario</H1>




<form action="#" method="post">

<label for="nombre">Nombre:</label>
<input type ="text" name="nombre" value="<%=p.getNombre()%>">
<br>

<label for="apellido1">Apellido1:</label>
<input type ="text" name="apellido1" value="<%=p.getApellido1()%>">
<br>

<label for="apellido2">Apellido2:</label>
<input type ="text" name="apellido2" value="<%=p.getApellido2()%>">
<br>

<label for="dni">DNI:</label>
<input type ="text" name="dni" value="<%=p.getDni()%>">
<br>

<label for="email">Email:</label>
<input type ="text" name="email" value="<%=p.getEmail()%>">



<br>
<br>

<input type = "submit"  class"btn btn-primary" svalue="Guardar cambios">
</form>
    
recuperar de Session los datos y ponerlos en un Formulario

<%@ include file="../includes/footer.jsp" %>