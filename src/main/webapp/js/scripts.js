/* Lenguaje JavaScript se ejecuta en el lado del Cliente */

// Esto no es JAVA

$(document).ready(function() {
	console.info("Documento READY");
	
	//ligamos plugin de DataTables a todas las tablas que tengan clas="tabla"
    $('.tabla').DataTable();
} );
