/* Lenguaje JavaScript se ejecuta en el lado del Cliente */

// Esto no es JAVA

$(document).ready(function() {
	console.info("Documento READY");
	
	//Activamos plugin de Datatables
	//a todas las tablas que tengan class="tabla"
	$('.tabla').DataTable();
	console.info("Databale cargado");
} );
