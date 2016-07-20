/* Lenguaje JavaScript se ejecuta en el lado del Cliente */

// Esto no es JAVA

$(document).ready(function() {
	console.info("Documento cargado");
	//Activamos Plugin de Datatables a todas las tablas cuya clase sea igual a tabla
    $('.tabla').DataTable();
});
