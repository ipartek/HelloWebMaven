/* Lenguaje JavaScript se ejecuta en el lado del Cliente */

// Esto no es JAVA

$(document).ready(function() {		
	//Enlazamos plugin de DataTables a todas las tablas con class="datatabla"
    $('.datatabla').DataTable({
	    language: {
	        processing:     "Procesando...",
	        search:         "Buscar&nbsp;:",
	        lengthMenu:     "Mostrar _MENU_ elementos",
	        info:           "Mostrando resultados _START_ a _END_ de _TOTAL_ registros",
	        infoEmpty:      "Mostrando 0 a 0 de 0 registros",
	        infoFiltered:   "(filtrado de un total de _MAX_ registros)",
	        infoPostFix:    "",
	        loadingRecords: "Cargando...",
	        zeroRecords:    "No se encontr&oacute; ning&uacute;n resultado",
	        emptyTable:     "Tabla vac&iacute;",
	        paginate: {
	            first:      "Primero",
	            previous:   "Anterior",
	            next:       "Siguiente",
	            last:       "&Uacute;ltimo"
	        },
	        aria: {
	            sortAscending:  ": Orden ascendente",
	            sortDescending: ": Orden descendente"
	            	}
	    }
    });
	console.info("DataTable cargado");
	
} );
