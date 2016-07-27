package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

/**
 * Interface de la capa Servicio
 * que declara la logica de negocio de los Personas
 */
public interface ServicePersona {
	
	/**
	 * Retorna los últimos 1000 Personas creados
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
	 * Modifica o crea un nuevo Persona
	 * @param p
	 * @throws Si no se puede guardar Persona
	 * @return Persona salvado
	 */
	Persona save(Persona p) throws Exception;
	
	/**
	 * Busca Personas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	List<Persona> search(String criterio);

}
