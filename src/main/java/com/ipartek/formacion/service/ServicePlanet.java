package com.ipartek.formacion.service;


import java.util.List;

import com.ipartek.formacion.pojo.Planeta;
/**
 *  Interfaz de la capa Servicio que declara la logica de negocio de los Planetas
 *
 */
public interface ServicePlanet {
	/**
	 * Retorna los ultimos 1000 planetas creados
	 * @return
	 */
	List<Planeta> getAll();
	
	/**
	 *  Busca planeta por su identificador
	 * @param id
	 * @return Planeta si encuentra, null si no existe
	 */
	Planeta getById(int id);
	
	/**
	 * Elimina planeta por su identificador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * Modifica o inserta un planeta
	 * @param p
	 * @throws si no se puede guardar planeta
	 * @return planeta salvado
	 */
	Planeta save(Planeta p) throws Exception;
	
	/**
	 * Buscar planetas que contengan el criterio  buscado por su nombre
	 * @param criterio
	 * @return
	 */
	List<Planeta> search(String criterio);
	
	
	
	

}
