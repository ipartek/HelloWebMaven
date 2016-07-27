package com.ipartek.formacion.service;



import com.ipartek.formacion.pojo.Persona;

import java.util.List;


/**
 *  Interface de la capa Servicio 
 *  que declara la logica de negocio de los Planetas
 */
public interface ServicePersona {

	/**
	 * retorna los ultimos 1000 persona creados
	 * @return
	 */
	List<Persona> getAll();	
	
	/**
	 * Busca persona por su identifador
	 * @param id
	 * @return Persona si encuentra, null si no existe
	 */
	Persona getById(long id);
	
	/**
	 * Elimna Persona por su identifador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * Modifica o crea un nuevo persona 
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
