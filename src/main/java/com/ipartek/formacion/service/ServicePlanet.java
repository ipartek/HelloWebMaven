package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

/**
 * Interfaz de la capa Servicio para declarar la lógica de negocio de los Planetas
 *
 */

public interface ServicePlanet {

	/**
	 * Retorna los últimos 1000 planetas creados
	 * @return
	 */
	List<Planeta> getAll();
	
	
	/**
	 * Busca Planeta por su identificador
	 * @param id
	 * @return Planeta si encuentra, null si no existe
	 */
	Planeta getById(long id);
		
	/**
	 * Elimina Planeta por su identificador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * Modifica o crea un nuevo Planeta
	 * @param p
	 * @throws Si no se puede guardar Planeta
	 * @return Planeta salvado
	 */
	Planeta save(Planeta p)throws Exception;
	
	/**
	 * Retorna planetas que contengan el término buscado "criterio" en su nombre
	 * @param criterio
	 * @return
	 */
	List<Planeta> search(String criterio);
	
}
