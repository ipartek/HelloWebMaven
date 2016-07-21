package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

/**
 * Interface de la capa Servicio
 * que declara la logica de negocio de los Planetas
 * @author Curso
 *
 */
public interface ServicePlanet {

	/**
	 * Retorna los ultimos 1000 planetas introducidos
	 * @return
	 */
	List<Planeta> getAll();
	
	/**
	 * Retorna Planeta por su identificador
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
	 * Modifica un Planeta existente o crea un Planeta nuevo
	 * @param p
	 * @throws Exception si no se puede guardar Planeta
	 * @return Planeta salvado
	 */
	Planeta save(Planeta p) throws Exception;
	
	/**
	 * Busca Planetas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	List<Planeta> search(String criterio);
	
}
