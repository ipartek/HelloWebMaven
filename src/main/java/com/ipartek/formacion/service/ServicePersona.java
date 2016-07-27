package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

/**
 * Interface de la capa Servicio
 * que declara la logica de negocio de las Personas
 * @author Curso
 *
 */
public interface ServicePersona {

	/**
	 * Retorna las ultimas 100 Personas introducidas
	 * @return
	 */
	List<Persona> getAll();
	
	/**
	 * Retorna Persona por su identificador
	 * @param id
	 * @return Planeta si encuentra, null si no existe
	 */
	Persona getById(long id);
	
	/**
	 * Elimina Persona por su identificador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * Modifica una Persona existente o crea una Persona nueva
	 * @param p
	 * @throws Exception si no se puede guardar Persona
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
