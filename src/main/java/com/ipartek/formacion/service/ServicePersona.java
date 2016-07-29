package com.ipartek.formacion.service;

import java.util.List;
import com.ipartek.formacion.pojo.Persona;
/**
 *  Interface de la capa Servicio 
 *  que declara la logica de negocio de las Personas
 */
public interface ServicePersona {
		/**
		 * retorna las ultimas 10 personas creadas
		 * @return
		 */
		List<Persona> getAll();	
		
		/**
		 * Busca persona por su identifador
		 * @param id
		 * @return Persona si encuentra, null si no existe
		 */
		Persona getById(int id);
		
		/**
		 * Elimina Persona por su identifador
		 * @param id
		 * @return
		 */
		boolean delete(int id);
		
		/**
		 * Modifica o crea una nueva persona
		 * @param p
		 * @throws Si no se puede guardar persona
		 * @return Persona salvado
		 */
		Persona save(Persona p) throws Exception;
		
		/**
		 * Busca personas que contengan el <b>criterio</b> buscado en su nombre
		 * @param criterio
		 * @return
		 */
		List<Persona> search(String criterio);
}
