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
        <div class="error-code m-b-10 m-t-20">¡Error 404! <i class="fa fa-warning"></i></div>
        <h3 class="font-bold">Recurso No existe</h3>

        <div class="error-desc">
            Perdón, pero la página a la que quieres acceder no se ha podido cargar.<br/>
            Prueba refrescando la página o haz click en el link de debajo para volver a la Homepage.
            <div>
                <a class=" login-detail-panel-button btn" href="http://localhost:8080/HelloWebMaven/">
                        <i class="fa fa-arrow-left"></i>
                        Homepage                        
                    </a>
            </div>
        </div>
    </div>
    </body>
</html>