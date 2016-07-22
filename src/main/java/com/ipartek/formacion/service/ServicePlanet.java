package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

/*
 * interface de la capa servicio que declara la logica de negocio de los planetas
 */

public interface ServicePlanet {
	
	/**
	 * retorna los ultimos mil planetas creados
	 * @return
	 */
	
	List<Planeta> getAll();
	
	/**
	 * busca planeta por su identificador
	 * @param id
	 * @return planeta si encuentra, null si no existe
	 */
	
	Planeta getById(long id);
	
	/**
	 * elimina planeta por su identificador
	 * @param id
	 * @return
	 */
	
	boolean delete(long id);
	
	/**
	 * modifica o crea un nuevo planeta
	 * @param p
	 * @throws si no se puede guardar planeta
	 * @return planeta salvado, 
	 */
	
	Planeta save(Planeta p) throws Exception;
	
	/**
	 * busca planetas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	
	List<Planeta> search(String nombrePlaneta);

}
