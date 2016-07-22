/* Lenguaje JavaScript se ejecuta en el lado del Cliente */

// Esto no es JAVA



$(document).ready(function() {
	console.info("Documento ready");
	//activar plugin de datatables a todas las tablas que tengan class="tabla"
    $('.tabla').DataTable();
} );

