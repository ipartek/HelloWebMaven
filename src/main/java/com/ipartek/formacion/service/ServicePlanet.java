package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

/**
 *  Interface de la capa Servicio 
 *  que declara la logica de negocio de los Planetas
 */
public interface ServicePlanet {

	/**
	 * retorna los ultimos 1000 planetas creados
	 * @return
	 */
	List<Planeta> getAll();	
	
	/**
	 * Busca planeta por su identifador
	 * @param id
	 * @return Planeta si encuentra, null si no existe
	 */
	Planeta getById(long id);
	
	/**
	 * Elimna Planeta por su identifador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * Modifica o crea un nuevo planeta 
	 * @param p
	 * @throws Si no se puede guardar planeta
	 * @return Planeta salvado
	 */
	Planeta save(Planeta p) throws Exception;
	
	/**
	 * Busca planetas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	List<Planeta> search(String criterio);
	
}
