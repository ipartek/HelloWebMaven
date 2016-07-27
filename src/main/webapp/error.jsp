<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<!-- juego de caracteres -->
<title>Login</title>
<!-- titulo de la pagina-pesta�a -->

<link rel="stylesheet"
	href="css/errorStyles.css">

</head>
<body>

<div class="error">
        <div class="error-code m-b-10 m-t-20">¡Error 500! <i class="fa fa-warning"></i></div>
        <h3 class="font-bold"><%=exception%></h3>

        <div class="error-desc">
            Perdón, pero la página a la que quieres acceder no se ha podido cargar.<br/>
            Prueba refrescando la página o haz click en el link de debajo para volver a la Homepage.
            <div>
                <a class=" login-detail-panel-button btn" href="http://localhost:8080/HelloWebMaven/">
                        <i class="fa fa-arrow-left"></i>
                        Homepage                        
                    </a>
             <br>
             <br>
             O prueba volviendo a la página anterior, pero atento a lo que tecleas.
             <br> 
             No somos amigos ni de los duplicados ni de los índices fuera de rango.
             <br>
                 <a href="javascript:window.history.back();">&laquo; Volver atrás</a>
                 
            </div>
        </div>
    </div>
    </body>
</html>