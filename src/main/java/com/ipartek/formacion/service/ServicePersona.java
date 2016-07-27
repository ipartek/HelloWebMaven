package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;



/**
 * Interfaz de la capa Servicio para declarar la lógica de negocio de las Personas
 *
 */

public interface ServicePersona {

	/**
	 * Retorna los últimos 100 Personas creadas
	 * @return
	 */
	List<Persona> getAll();
	
	
	/**
	 * Busca Persona por su identificador
	 * @param id
	 * @return Persona si encuentra, null si no existe
	 */
	Persona getById(long id);
		
	/**
	 * Elimina Persona por su identificador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * Modifica o crea una nueva Persona
	 * @param p
	 * @throws Si no se puede guardar Persona
	 * @return Persona salvada
	 */
	Persona save(Persona p)throws Exception;
	
	
	
	
}
